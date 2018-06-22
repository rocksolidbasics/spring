package org.study.spring.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.study.spring.rest.pojo.BaseResponse;
import org.study.spring.rest.pojo.PaymentRequest;

@RestController
@RequestMapping("/payment")
public class PaymentController {


	private static final String SUCCESS_STATUS = "success";
	private static final String SHARED_KEY = "SHARED_KEY";
	private static final int CODE_SUCCESS = 100;
	private static final String ERROR_STATUS = "error";
	private static final int AUTH_FAILURE = 102;

	/**
	 * RequestMapping(value = "/") is different from not providing a request mapping.
	 * If a '/' is specified in the @RequestMapping, the slash should be there in the access URL. If
	 * there was no value attribute specified, then it is assumed as a URL with "/" or without it.
	 * To know the mappings it good to check the startup mapping logs on how the path is mapped to methods. 
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public BaseResponse testResponse() {
		BaseResponse br = new BaseResponse();
		br.setCode(CODE_SUCCESS);
		br.setStatus(SUCCESS_STATUS);
		
		return br;
	}

	@RequestMapping(value="pay", method=RequestMethod.POST)
	public BaseResponse pay(@RequestParam(value="key") String key,
			@RequestBody PaymentRequest request) {
		BaseResponse response = new BaseResponse();
		
		if(key.equalsIgnoreCase(SHARED_KEY)) {
			response.setDiscount(10);
			response.setStatus(SUCCESS_STATUS);
			response.setCode(CODE_SUCCESS);
		} else {
			response.setStatus(ERROR_STATUS);
			response.setCode(AUTH_FAILURE);
		}
		
		return response;
	}
}
