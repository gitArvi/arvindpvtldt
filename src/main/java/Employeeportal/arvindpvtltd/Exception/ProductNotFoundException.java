package Employeeportal.arvindpvtltd.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductNotFoundException extends Exception {
       
	@ExceptionHandler(value= ProductNotFoundException.class)
	public ResponseEntity<Object> exception(ProductNotFoundException exception)
	{
		return new  ResponseEntity<Object>("product not found exception",HttpStatus.NOT_FOUND);
	}
}
