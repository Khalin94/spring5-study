package controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("/")
public class CommonException {
	
	@ExceptionHandler(RuntimeException.class)
	public String handleRuntimeException() {
		return "error/commonException";
	}

}
