package ext.util;

import java.util.regex.Pattern;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

public class ELUtils {
	public final static Pattern elPattern = Pattern
			.compile("(#|\\$)\\{[\\s\\S]+?\\}");

	public static boolean isEL(String exp) {
		if (exp == null)
			return false;
		return elPattern.matcher(exp).find();
	}

	public static String getELExpr(String exp) {
		if (isEL(exp))
			return exp;
		else {
			exp = "#{" + exp + "}";
			return exp;
		}
	}

	public static ValueExpression createValueExpression(FacesContext context,String exp) {
		ELContext elContext = context.getELContext();

		ExpressionFactory expFac = context.getApplication()
				.getExpressionFactory();

		return expFac.createValueExpression(elContext, getELExpr(exp), Object.class);
	}

	public static Object evaluate(FacesContext context, String exp) {
		ELContext elContext = context.getELContext();

		ValueExpression ve = createValueExpression(context, exp);

		return ve.getValue(elContext);
	}
}
