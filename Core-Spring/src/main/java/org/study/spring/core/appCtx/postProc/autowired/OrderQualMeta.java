package org.study.spring.core.appCtx.postProc.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.study.spring.core.appCtx.postProc.autowired.ann.AddressAnn;
import org.study.spring.core.appCtx.postProc.autowired.ann.AddressAnn.ADDRESS_LOCATION;
import org.study.spring.core.appCtx.postProc.autowired.ann.AddressAnn.ADDRESS_TYPE;

public class OrderQualMeta {

	@Autowired
	@AddressAnn(type=ADDRESS_TYPE.Billing, location=ADDRESS_LOCATION.Home)
	private Address billingHomeAddress;
	
	@Autowired
	@AddressAnn(type=ADDRESS_TYPE.Shipping, location=ADDRESS_LOCATION.Home)
	private Address shippingHomeAddress;
	
	public Address getBillingHomeAddress() {
		return billingHomeAddress;
	}
	public void setBillingHomeAddress(Address billingHomeAddress) {
		this.billingHomeAddress = billingHomeAddress;
	}
	public Address getShippingHomeAddress() {
		return shippingHomeAddress;
	}
	public void setShippingHomeAddress(Address shippingHomeAddress) {
		this.shippingHomeAddress = shippingHomeAddress;
	}
}
