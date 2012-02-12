/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * Copyright 2009-2010 5base, Inc. All rights reserved.
 * 
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 3 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.
 * See the License for the specific language governing permissions and limitations under the License.
 * 
 * When distributing the software, include this License Header Notice in each
 * file and include 5base License file at root If applicable, add the following below the License
 * Header, with the fields enclosed by brackets [] replaced by your own
 * identifying information: "Portions Copyrighted [year]
 * [name of copyright owner]"
 * 
 * Open Source License
 * ------------------------------------------------------------------------------------------
 * Ext is licensed under the terms of the Open Source GPL 3.0 license. 
 * http://www.gnu.org/licenses/gpl.html
 */
package com.abner.fence.ajax;

import java.util.HashMap;
import java.util.Map;

import javax.el.ELContext;
import javax.el.ELException;
import javax.el.ValueExpression;
import javax.faces.FacesException;
import javax.faces.component.UIComponentBase;
import javax.faces.component.behavior.AjaxBehavior;
import javax.faces.component.behavior.FacesBehavior;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorListener;


/**
 * @created Sep 15, 2010 12:13:42 PM
 * @author arron
 
 * @description ExtAjaxBehavior,this class is extend the AjaxBehavior class and add some property
 */
@FacesBehavior("com.fence.fence.behavior.Ajax")
public class ExtAjaxBehavior extends AjaxBehavior {
	public static final String BEHAVIOR_ID = "com.fence.fence.behavior.Ajax";
	private static final String ARGS = "args";
	private static final String HANDLER = "handler";
	private static final String CONFIRM = "confirm";

	private boolean submitting = false;
	private String args;
	private String handler;
	private String confirm;

	public ExtAjaxBehavior() {
		super();
	}

	@Override
	public String getRendererType() {
		return BEHAVIOR_ID;
	}

	@Override
	public void addAjaxBehaviorListener(AjaxBehaviorListener listener) {
		super.addAjaxBehaviorListener(listener);
		submitting = true;
	}

	public String getArgs() {
		return (String) eval(ARGS, args);
	}

	public void setArgs(String args) {
		this.args = args;
		clearInitialState();
	}

	public String getHandler() {
		return (String) eval(HANDLER, handler);
	}

	public void setHandler(String handler) {
		this.handler = handler;
		clearInitialState();
	}

	public String getConfirm() {
		return (String) eval(CONFIRM, confirm);
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
		clearInitialState();
	}

	@Override
	public Object saveState(FacesContext context) {
		if (context == null) {
			throw new NullPointerException();
		}
		Object[] values;

		Object superState = super.saveState(context);

		if (initialStateMarked()) {
			if (superState == null) {
				values = null;
			} else {
				values = new Object[] { superState };
			}
		} else {
			values = new Object[5];

			values[0] = superState;
			values[1] = args;
			values[2] = handler;
			values[3] = confirm;
			values[4] = saveBindings(context, bindings);
		}

		return values;
	}

	@Override
	public void restoreState(FacesContext context, Object state) {
		if (context == null) {
			throw new NullPointerException();
		}
		if (state != null) {
			Object[] values = (Object[]) state;
			super.restoreState(context, values[0]);

			if (values.length != 1) {
				args = (String) values[1];
				handler = (String) values[2];
				confirm = (String) values[3];
				bindings = restoreBindings(context, values[4]);
				clearInitialState();
			}
		}
	}

	// --------------------------------------------------------- Private Methods

	private static Object saveBindings(FacesContext context, Map<String, ValueExpression> bindings) {
		if (bindings == null) {
			return (null);
		}

		Object values[] = new Object[2];
		values[0] = bindings.keySet().toArray(new String[bindings.size()]);

		Object[] bindingValues = bindings.values().toArray();
		for (int i = 0; i < bindingValues.length; i++) {
			bindingValues[i] = UIComponentBase.saveAttachedState(context, bindingValues[i]);
		}

		values[1] = bindingValues;

		return (values);
	}

	// Utility for restoring bindings from state
	private static Map<String, ValueExpression> restoreBindings(FacesContext context, Object state) {

		// Note: This code is copied from UIComponentBase. See note above
		// in saveBindings().

		if (state == null) {
			return (null);
		}
		Object values[] = (Object[]) state;
		String names[] = (String[]) values[0];
		Object states[] = (Object[]) values[1];
		Map<String, ValueExpression> bindings = new HashMap<String, ValueExpression>(names.length);
		for (int i = 0; i < names.length; i++) {
			bindings.put(names[i], (ValueExpression) UIComponentBase.restoreAttachedState(context, states[i]));
		}
		return (bindings);
	}

	private Object eval(String propertyName, Object value) {
		if (value != null) {
			return value;
		}

		ValueExpression expression = getValueExpression(propertyName);

		if (expression != null) {
			FacesContext ctx = FacesContext.getCurrentInstance();
			return expression.getValue(ctx.getELContext());
		}

		return null;
	}

	private Map<String, ValueExpression> bindings;

	public void setValueExpression(String name, ValueExpression binding) {
		super.setValueExpression(name, binding);
		if (binding != null) {
			if (binding.isLiteralText()) {
				setLiteralValue(name, binding);
			} else {
				if (bindings == null) {
					bindings = new HashMap<String, ValueExpression>(6, 1.0f);
				}

				bindings.put(name, binding);
			}
		} else {
			if (bindings != null) {
				bindings.remove(name);
				if (bindings.isEmpty()) {
					bindings = null;
				}
			}
		}
		clearInitialState();
	}

	private void setLiteralValue(String propertyName, ValueExpression expression) {
		assert (expression.isLiteralText());
		Object value;
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		try {
			value = expression.getValue(context);
		} catch (ELException ele) {
			throw new FacesException(ele);
		}

		if (ARGS.equals(propertyName)) {
			args = (String) value;
		} else if (HANDLER.equals(propertyName)) {
			handler = (String) value;
		} else if (CONFIRM.equals(propertyName)) {
			confirm = (String) value;
		}
	}

	public boolean isSubmitting() {
		if (submitting)
			return submitting;

		if (this.getRender() != null && !this.getRender().isEmpty())
			return true;

		return false;
	}
}
