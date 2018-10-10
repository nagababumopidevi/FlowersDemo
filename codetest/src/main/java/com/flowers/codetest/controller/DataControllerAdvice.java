package com.flowers.codetest.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.flowers.codetest.Exception.ErrorContainer;

@RestControllerAdvice(assignableTypes = {DataController.class})
public class DataControllerAdvice {
	  @ExceptionHandler(Exception.class)
	    public ErrorContainer handleException(Exception e, HttpServletResponse response) {
		   return getErrorContainer(e.getMessage());
		  
	  }
	  
	  	  @ExceptionHandler(IOException.class)
	  	    public ErrorContainer handleIOException(Exception e, HttpServletResponse response) {
			   
			   return getErrorContainer(e.getMessage());
	  		  
	  	  }
	  	  
	  	  private ErrorContainer getErrorContainer(String errMsg){
	  		ErrorContainer err = new ErrorContainer();
			   err.setErrorMessage(errMsg);
			   
			   return err;
	  	  }

}
