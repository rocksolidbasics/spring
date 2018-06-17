package org.study.spring.core.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.study.spring.core.appCtx.beans.Product;

public class SimpleELRunner {

	public static void main(String[] args) {
		SimpleELRunner elr = new SimpleELRunner();
		elr.literalParsing();
		elr.methodInvocation();
		elr.parsingViaEvaluationContext();
	}

	private void methodInvocation() {
		ExpressionParser p = new SpelExpressionParser();
		Expression exp = p.parseExpression("'Hello World'.concat('!')");
		System.out.println("Using cast => " + (String)exp.getValue());
		System.out.println("Using getValue(Type) => " + exp.getValue(String.class));
	}

	/**
	 * Using Expression.getValue() on complete expressions (not on a statement)
	 * 'Hello World'.concat() is an expression as it can be resolved to a value,
	 * but not for if statements.
	 * Moroever, these expressions are self contained as the object on which the
	 * methods has to be invoked are defined and parsed within.
	 */
	private void literalParsing() {
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("'Hello World'");
		System.out.println("Simple string literal parsing => " + (String)exp.getValue());
	}
	
	/**
	 * SpEL can defined expressions which are not having a context of an object, i.e.,
	 * the object type on which they may act is not known. It will be supplied in later 
	 * using the object context supplied later
	 */
	private void parsingViaEvaluationContext() {
		Product prod = new Product();
		ExpressionParser p = new SpelExpressionParser();
		Expression exp = p.parseExpression("sku");
		String sku = (String)exp.getValue(prod);
		String skuSame = exp.getValue(prod, String.class);
		System.out.println("Using an independant expression on an arbitrary object => Product.sku = " + sku);
	}
}
