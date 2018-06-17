package org.study.spring.core.spel;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.study.spring.core.spel.beans.IdGenerator;
import org.study.spring.core.spel.beans.Inventor;
import org.study.spring.core.spel.beans.PlaceOfBirth;
import org.study.spring.core.spel.beans.Society;

public class LangRefRunner {
	
	private Inventor inv;
	private Inventor adv1;
	private Society soc;
	
	private ClassPathXmlApplicationContext xctx;

	public static void main(String[] args) {
		LangRefRunner lrf = new LangRefRunner();
		lrf.createTestObjects();
		
		lrf.literalExpressions();
		lrf.listsAndMap();
		lrf.methodCalls();
		lrf.operatorCompare();
		lrf.comparisons();
		lrf.logicalAndMathOperators();
		lrf.valueAssignment();
		lrf.ClassInstancesOrStatics();
		lrf.constructorUsage();
		lrf.contextVariables();
		lrf.methodReferences();
		lrf.getBeanReferences();
		lrf.conditionalOperators();
		lrf.collectionSelection();
		lrf.collectionProjection();
		lrf.expressionTemplating();
	}

	/**
	 * Lets use an expression inside a string expression. A ParserContext implementation
	 * needs to be supplied to parse the template expression
	 */
	private void expressionTemplating() {
		ExpressionParser p = new SpelExpressionParser();
		Expression exp = p.parseExpression("Random number is #{T(java.lang.Math).random()}.", new TemplateParserContext());
		System.out.println("Template parsed text => " + exp.getValue(String.class));
	}
	
	private class TemplateParserContext implements ParserContext {

		@Override
		public boolean isTemplate() {
			return true;
		}

		@Override
		public String getExpressionPrefix() {
			return "#{";
		}

		@Override
		public String getExpressionSuffix() {
			return "}";
		}
		
	}

	/**
	 * Operator used to extract a sub-list of the properties of the target element, which match a
	 * given criteria. For e.g., a sub-list of cities from the list of Inventors
	 */
	private void collectionProjection() {
		ExpressionParser p = new SpelExpressionParser();
		Expression e = p.parseExpression("Members.![Nationality == 'Croatian']");
		System.out.println("First member match => " + e.getValue(soc, List.class));
		
		e = p.parseExpression("Members.![Nationality]");
		System.out.println("First member match => " + e.getValue(soc, List.class));
	}

	/**
	 * Operators used for filtering are:
	 * .?[expression] - For filtering all matches
	 * .^[expression] - Get first in all matches
	 * .$[expression] - Get last in all matches
	 */
	private void collectionSelection() {
		ExpressionParser p = new SpelExpressionParser();
		Expression e = p.parseExpression("Members.?[Nationality == 'Croatian']");
		System.out.println("All member matches => " + e.getValue(soc, List.class));
		
		e = p.parseExpression("Members.^[Nationality == 'Croatian']");
		System.out.println("First member match => " + e.getValue(soc, List.class));
		
		e = p.parseExpression("Members.$[Nationality == 'Croatian']");
		System.out.println("Last member match => " + e.getValue(soc, List.class));
		
	}

	private void conditionalOperators() {
		ExpressionParser p = new SpelExpressionParser();
		StandardEvaluationContext eCtx = new StandardEvaluationContext();
		eCtx.setVariable("queryName", "Tesla");
		Expression exp = p.parseExpression("isMember(#queryName) ? #queryName : 'Not a member'");
		System.out.println("Ternary operator value => " + exp.getValue(eCtx, soc, String.class));
		
		//Elvis operator usage
		exp = p.parseExpression("isMember(#queryName)?:'Not a member'");
		System.out.println("Elvis operator => " + exp.getValue(eCtx, soc, String.class));
		
		//Safe navigation (null checking) operator '?.' usage
		Inventor testInv = new Inventor("Tesla N", "Serbia");
		exp = p.parseExpression("placeOfBirth?.city");
		System.out.println("Safe null check operator => " + exp.getValue(testInv));
	}

	private void getBeanReferences() {
		this.initCtx();
		ExpressionParser p = new SpelExpressionParser();
		StandardEvaluationContext ctx = new StandardEvaluationContext();
		ctx.setBeanResolver(new BeanFactoryResolver(this.xctx.getBeanFactory()));
		IdGenerator invRef = p.parseExpression("@idGenerator").getValue(ctx, IdGenerator.class);
		System.out.println("IdGenerator bean reference => " + invRef);
		//System.out.println("IdGenerator factory bean reference => " + p.parseExpression("&idGenerator").getValue(ctx));
	}

	/**
	 * Only static methods can be called via function references => #methodName() 
	 */
	private void methodReferences() {
		Method m = null;
		try {
			m = Inventor.class.getDeclaredMethod("getClassDescription");
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
		context.setVariable("mInventorDesc", m);
		ExpressionParser p = new SpelExpressionParser();
		String desc = p.parseExpression("#mInventorDesc()").getValue(context, inv, String.class);
		System.out.println("Inventor static class call vie #getDescription() => " + desc);
	}

	private void contextVariables() {
		Inventor tesla = new Inventor("Tesla", "Serbian");
		EvaluationContext ctx = SimpleEvaluationContext.forReadWriteDataBinding().build();
		ctx.setVariable("newName", "Mike Tesla");
		
		ExpressionParser p = new SpelExpressionParser();
		Expression exp = p.parseExpression("Name = #newName");
		System.out.println(exp.getValue(ctx, tesla) + ", " + tesla.toString());
	}

	private void constructorUsage() {
		ExpressionParser p = new SpelExpressionParser();
		Expression exp = p.parseExpression("new org.study.spring.core.spel.beans.Inventor('Devi', 'Indian')");
		System.out.println("Constructor call => " + exp.getValue(Inventor.class).getName());
		
		//Calling constructors with methods
		exp = p.parseExpression("Members.add(new org.study.spring.core.spel.beans.Inventor('Shyam', 'Indian1'))");
		System.out.println("Constructor called within add list method: List contents => " +
				exp.getValue(soc) + ", " + soc.getMembers());
	}

	/**
	 * T(<type>) is used to denote a class instance, and is also used to invoke
	 * static methods on that class. For any classes not belonging to java.lang
	 * the full package name needs to be provided
	 */
	private void ClassInstancesOrStatics() {
		ExpressionParser p = new SpelExpressionParser();
		Expression exp = p.parseExpression("T(String)");
		System.out.println("String class => " + exp.getValue(Class.class));
		
		exp = p.parseExpression("T(Thread).currentThread().getName()");
		System.out.println("Current thread name => " + exp.getValue(String.class));
	}

	private void valueAssignment() {
		ExpressionParser p = new SpelExpressionParser();
		Expression exp = p.parseExpression("name");
		
		Inventor tmpInv = new Inventor("Anil", "India");
		exp.setValue(tmpInv, "Rohit");
		System.out.println("After change of inventor name from Anil -> Rohit => " + tmpInv.getName());
		
		Inventor tmpInv2 = new Inventor("Anil", "India");
		exp = p.parseExpression("name = 'Rohit2'");
		System.out.println("After change of inventor name using getValue() => " + exp.getValue(tmpInv2, String.class));
	}

	private void logicalAndMathOperators() {
		ExpressionParser p = new SpelExpressionParser();
		System.out.println("Is true and false => " + p.parseExpression("true and false").getValue(Boolean.class));
		System.out.println("isMember('Tesla') and isMember('Shyam') => " + 
				p.parseExpression("isMember('Tesla') and isMember('Shyam')").getValue(soc, Boolean.class));
		System.out.println("isMember('Tesla') and !isMember('Shyam') => " + 
				p.parseExpression("isMember('Tesla') && !isMember('Shyam')").getValue(soc, Boolean.class));
		System.out.println("8/5 % 2 => " + p.parseExpression("8/5 % 2").getValue(Integer.class));
	}

	/**
	 * Note: A type in the expression is specified using T(<Class_name>) format
	 * Comparisons:
	 * Arithmetic	: +, -, *, /, %, ^, div, mod
	 * Relational	: <, >, ==, !=, <=, >=, lt, gt, eq, ne, le, ge\
	 * Logical		: and, or, not, &&, ||, !
	 * Conditional	: ?:
	 */
	private void comparisons() {
		ExpressionParser p = new SpelExpressionParser();
		Expression exp = p.parseExpression("'xyz' instanceof T(Integer)");
		System.out.println("Is xyz and integer => " + exp.getValue(Boolean.class));
		boolean trueValue = p.parseExpression(
		        "'5.00' matches '^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class);
		System.out.println("Regex expression match => " + trueValue);
	}

	private void operatorCompare() {
		ExpressionParser p = new SpelExpressionParser();
		Expression exp = p.parseExpression("2 == 2");
		System.out.println("Is 2 == 2: " + exp.getValue());
	}

	private void methodCalls() {
		ExpressionParser p = new SpelExpressionParser();
		Expression exp = p.parseExpression("'abc'.substring(1,3)");
		System.out.println("String substring call => " + exp.getValue());
		
		exp = p.parseExpression("isMember('Tesla')");
		System.out.println("Is member method call => " + exp.getValue(soc, Boolean.class));
	}

	private void literalExpressions() {
		ExpressionParser p = new SpelExpressionParser();
		Expression exp = p.parseExpression("6.93049E+23");
		System.out.println("Exponent value => " + exp.getValue(Double.class));
		
		Object nullValue = p.parseExpression("null").getValue();
		Assert.assertNull("Value is null => ", nullValue);
	}
	
	private void listsAndMap() {
		ExpressionParser p = new SpelExpressionParser();	//    Vivaan
		Expression exp = p.parseExpression("Birthdate.Year + 1902");
		int year = exp.getValue(inv, Integer.class);
		System.out.println("Property access => " + year);
		
		exp = p.parseExpression("placeOfBirth.City");
		System.out.println("Property access => City : " + exp.getValue(inv, String.class));
		
		exp = p.parseExpression("inventions[1]");
		System.out.println("Invention name at index 1 => " + exp.getValue(inv, String.class));
		
		exp = p.parseExpression("Officers['advisors'][0].PlaceOfBirth.Country");
		System.out.println("Advisor's country => " + exp.getValue(soc, String.class));
		
		exp = p.parseExpression("{1, 2, 3, 4, 5}");								//{} means empty array
		List<Integer> listInt = exp.getValue(List.class);
		System.out.println(listInt);
		exp = p.parseExpression("{{1,2,3}, {4,5,6}}");
		List<List<Integer>> listOfListInt = exp.getValue(List.class);
		System.out.println(listOfListInt);
		
		exp = p.parseExpression("{name: 'Nikola', dob: '10-July-1856'}");		//{:} mean empty map
		Map map = exp.getValue(HashMap.class);
		System.out.println(map);
	}
	
	private void createTestObjects() {
		inv = new Inventor("Tesla", "Croatian");
		PlaceOfBirth pob = new PlaceOfBirth("Croatian");
		pob.setCountry("CR");
		inv.setPlaceOfBirth(pob);
		String[] invs = {"Motor", "Electricity"};
		inv.setInventions(invs);
		
		adv1 = new Inventor("Advisor A", "Indian");
		PlaceOfBirth pob2 = new PlaceOfBirth("Delhi");
		pob2.setCountry("IN");
		adv1.setPlaceOfBirth(pob2);
		
		soc = new Society();
		List<Inventor> lst = new ArrayList<Inventor>();
		lst.add(adv1);
		soc.getOfficers().put("advisors", lst);
		soc.getMembers().add(inv);
	}
	
	private void initCtx() {
		xctx = new ClassPathXmlApplicationContext("classpath:spelUsage.xml");
	}

}
