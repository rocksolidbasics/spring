package org.study.spring.core.spel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.study.spring.core.profiles.beans.Customer;

public class SimpleEvaluationContextRunner {

	public static void main(String[] args) {
		SimpleEvaluationContextRunner secRunner = new SimpleEvaluationContextRunner();
		secRunner.setProps();
		secRunner.autoGrowLists();
	}
	
	/**
	 * Auto grows the list when new Customer object is added, because of the parser configuration
	 * provided to the parser. The same code may not work with setProps() call and will throw
	 * an index not found error
	 */
	private void autoGrowLists() {
		CustomerList simpleList = new CustomerList();
		
		//First value is for AutoGrowNullReferences and second argument is for AutoGrowLists
		SpelParserConfiguration parserConfig = new SpelParserConfiguration(true, true);
		ExpressionParser parser = new SpelExpressionParser(parserConfig);
		
		Expression exp = parser.parseExpression("custList[0]");
		exp.setValue(simpleList, new Customer());
		System.out.println("Auto-grow the list as item is inserted => " + simpleList.getCustList().get(0));
	}

	/**
	 * Note: Restricted instances of the EvaluationContext might have been to induce security in the evaluation 
	 * string, in use-cases where these strings are input by system users to configure certain services. In places
	 * where the underlying tasks should not write anything to a bean, expression received to set variable will be
	 * avoided when such statements are provided in a read-only context
	 */
	private void setProps() {
		Simple simpleList = new Simple(true);
		EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
		ExpressionParser parser = new SpelExpressionParser();

		Expression exp = parser.parseExpression("booleanList[0]");
		System.out.println("List values before change => " + simpleList.getBooleanList().get(0));
		exp.setValue(context, simpleList, "false");
		System.out.println("List values after change => " + simpleList.getBooleanList().get(0));
	}
	
	private class CustomerList {
		private List<Customer> custList = new ArrayList<Customer>();

		public List<Customer> getCustList() {
			return custList;
		}

		public void setCustList(List<Customer> custList) {
			this.custList = custList;
		}
	}
	
	private class Simple {
		public List<Boolean> booleanList = new ArrayList<Boolean>();
		
		public Simple(boolean init) {
			//Without this the set won't work from SpEL expression, and index not found
			//error is thrown, when we try to run the expression "booleanList[0]". Use the
			//SpelParserConfiguration auto-grow feature to automatically grow arrays
			if(init)
				booleanList.add(new Boolean(true));
		}
		
		public List<Boolean> getBooleanList() {
			return booleanList;
		}

		public void setBooleanList(List<Boolean> booleanList) {
			this.booleanList = booleanList;
		}
	}

}
