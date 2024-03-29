package ext.base;

import javax.faces.component.StateHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.el.EvaluationException;
import javax.faces.el.MethodBinding;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@SuppressWarnings("deprecation")
public class MethodBindingValidator extends MethodBindingAdapterBase implements
		Validator, StateHolder {

	// ------------------------------------------------------ Instance Variables

	private MethodBinding methodBinding = null;

	public MethodBindingValidator() {
	}

	/**
	 * <p>
	 * Construct a {@link Validator} that contains a {@link MethodBinding}.
	 * </p>
	 */
	public MethodBindingValidator(MethodBinding methodBinding) {

		super();
		this.methodBinding = methodBinding;

	}

	public MethodBinding getWrapped() {
		return methodBinding;
	}

	// ------------------------------------------------------- Validator

	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		if (null == context || null == component) {
			throw new NullPointerException();
		}
		try {
			methodBinding.invoke(context, new Object[] { context, component,
					value });
		} catch (EvaluationException ee) {
			Throwable cause = this.getExpectedCause(ValidatorException.class,
					ee);
			if (cause instanceof ValidatorException) {
				throw ((ValidatorException) cause);
			}
			if (cause instanceof RuntimeException) {
				throw ((RuntimeException) cause);
			}
			throw new IllegalStateException(ee);
		}

	}

	// 
	// Methods from StateHolder
	//

	public Object saveState(FacesContext context) {
		Object result = null;
		if (!tranzient) {
			if (methodBinding instanceof StateHolder) {
				Object[] stateStruct = new Object[2];

				// save the actual state of our wrapped methodBinding
				stateStruct[0] = ((StateHolder) methodBinding)
						.saveState(context);
				// save the class name of the methodBinding impl
				stateStruct[1] = methodBinding.getClass().getName();

				result = stateStruct;
			} else {
				result = methodBinding;
			}
		}

		return result;
	}

	public void restoreState(FacesContext context, Object state) {
		// if we have state
		if (null == state) {
			return;
		}

		if (!(state instanceof MethodBinding)) {
			Object[] stateStruct = (Object[]) state;
			Object savedState = stateStruct[0];
			String className = stateStruct[1].toString();
			MethodBinding result = null;

			Class<?> toRestoreClass;
			if (null != className) {
				try {
					toRestoreClass = loadClass(className, this);
				} catch (ClassNotFoundException e) {
					throw new IllegalStateException(e);
				}

				if (null != toRestoreClass) {
					try {
						result = (MethodBinding) toRestoreClass.newInstance();
					} catch (InstantiationException e) {
						throw new IllegalStateException(e);
					} catch (IllegalAccessException a) {
						throw new IllegalStateException(a);
					}
				}

				if (null != result && null != savedState) {
					// don't need to check transient, since that was
					// done on the saving side.
					((StateHolder) result).restoreState(context, savedState);
				}
				methodBinding = result;
			}
		} else {
			methodBinding = (MethodBinding) state;
		}
	}

	private boolean tranzient = false;

	public boolean isTransient() {
		return tranzient;
	}

	public void setTransient(boolean newTransientValue) {
		tranzient = newTransientValue;
	}

	//
	// Helper methods for StateHolder
	//

	private static Class<?> loadClass(String name, Object fallbackClass)
			throws ClassNotFoundException {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		if (loader == null) {
			loader = fallbackClass.getClass().getClassLoader();
		}
		return Class.forName(name, false, loader);
	}
}
