package org.study.spring.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadDataException extends RuntimeException {

	private static final long serialVersionUID = -6175980282323934960L;

	public BadDataException(String message) {
		super(message);
	}
}
