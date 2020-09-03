package com.banco.emprestimo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UserAuthenticationNotFoundException extends RuntimeException {

	public UserAuthenticationNotFoundException(String message) {
		super(message);
	}

}
