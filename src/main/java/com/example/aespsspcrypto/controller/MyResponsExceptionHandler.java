package com.example.aespsspcrypto.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Author: Mobolaji Ake
 * Property of Nigeria Interbank Settlement Systems
 * Use for AES AfriGO Encyption as a Service
 */

@ControllerAdvice
public class MyResponsExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({IllegalArgumentException.class,InvalidAlgorithmParameterException.class,NoSuchPaddingException.class, IllegalBlockSizeException.class, UnsupportedEncodingException.class, NoSuchAlgorithmException.class, BadPaddingException.class, InvalidKeyException.class})
	protected ResponseEntity<Void> handleResourceNotFound(RuntimeException ex, WebRequest request) {
		return ResponseEntity.badRequest().build();
	}


}