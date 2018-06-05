package org.study.spring.core.appCtx.postProc.autowired.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Qualifier;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface AddressAnn {
	
	public enum ADDRESS_TYPE { Billing, Shipping };
	public enum ADDRESS_LOCATION { Home, Office };
	
	ADDRESS_TYPE type();
	
	ADDRESS_LOCATION location();
}
