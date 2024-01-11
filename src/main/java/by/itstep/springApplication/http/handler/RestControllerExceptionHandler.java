package by.itstep.springApplication.http.handler;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(basePackages = "by.itstep.springApplication.http.rest")
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {
}
