package com.example.myapplication.apierror;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static java.util.stream.Collectors.toList;

@ControllerAdvice
public class ApiValidationExceptionHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(ApiValidationExceptionHandler.class.getName());

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();

        List<ApiFieldError> apiFieldErrors = bindingResult
                .getFieldErrors()
                .stream()
                .map(fieldError -> new ApiFieldError(
                        fieldError.getField(),
                        fieldError.getCode(),
                        fieldError.getRejectedValue())
                )
                .collect(toList());

        List<ApiGlobalError> apiGlobalErrors = bindingResult
                .getGlobalErrors()
                .stream()
                .map(globalError -> new ApiGlobalError(
                        globalError.getCode())
                )
                .collect(toList());

        ApiErrorsView apiErrorsView = new ApiErrorsView(apiFieldErrors, apiGlobalErrors);

        return new ResponseEntity<>(apiErrorsView, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
