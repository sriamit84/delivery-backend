package com.fresure.controlleradvice;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fresure.constants.Constants;
import com.fresure.exceptions.BadInputException;
import com.fresure.exceptions.EntityNotFoundException;
import com.fresure.exceptions.FresureException;
import com.fresure.model.Subscription;
import com.fresure.payload.response.ErrorMessage;
import com.fresure.payload.response.FresureResponse;
import com.fresure.payload.response.HTTPStatus;
import com.fresure.payload.response.ResponseStatus;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class ErrorHandlingControllerAdvice {
  @Autowired
  private MessageSource messageSource;


  @ExceptionHandler({ EntityNotFoundException.class})
  ResponseEntity<FresureResponse> handleException(EntityNotFoundException exception) {
    FresureResponse<Subscription> fresureResponse = new FresureResponse<>();
    fresureResponse.setStatus(ResponseStatus.FAILED).
            addErrorMessage(new ErrorMessage(HTTPStatus.UNPROCESSABLE_ENTITY.getCode(), exception.getMessage()));
    return new ResponseEntity<>(fresureResponse, BAD_REQUEST);
  }

  @ExceptionHandler({ FresureException.class})
  ResponseEntity<FresureResponse> handleInternalServerException(FresureException exception) {
    FresureResponse<Subscription> fresureResponse = new FresureResponse<>();
    fresureResponse.setStatus(ResponseStatus.FAILED).
            addErrorMessage(new ErrorMessage(INTERNAL_SERVER_ERROR.toString(), exception.getMessage()));
    return new ResponseEntity<>(fresureResponse, INTERNAL_SERVER_ERROR);
  }

//  @ExceptionHandler(ConstraintViolationException.class)
//  @ResponseStatus(HttpStatus.BAD_REQUEST)
//  @ResponseBody
//  ErrorResponse onConstraintValidationException(ConstraintViolationException e) {
//    ErrorResponse error = new ErrorResponse();
//    for (ConstraintViolation violation : e.getConstraintViolations()) {
//      error.getErrors().add(new java.lang.Error(violation.getPropertyPath().toString(), violation.getMessage()));
//    }
//    return error;
//  }
//
//  @ExceptionHandler(MethodArgumentNotValidException.class)
//  @ResponseStatus(HttpStatus.BAD_REQUEST)
//  @ResponseBody
//  ResponseEntity<ErrorResponse> onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
//    ErrorResponse error = new ErrorResponse();
//    for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
//      error.getErrors().add(new java.lang.Error(fieldError.getField(), fieldError.getDefaultMessage()));
//    }
//    return new ResponseEntity<>(error, BAD_REQUEST);
//  }
//
//  @ExceptionHandler(InvalidFormatException.class)
//  @ResponseStatus(HttpStatus.BAD_REQUEST)
//  @ResponseBody
//  ResponseEntity<ErrorResponse> onInvalidFormatException(InvalidFormatException e) {
//    ErrorResponse error = new ErrorResponse();
//      error.getErrors().add(new java.lang.Error(e.getPath().get(0).getFieldName(), e.getValue()+" is in incorrect format"));
//
//    return new ResponseEntity<>(error, BAD_REQUEST);
//  }
//

//
//  @ExceptionHandler(EmployeeApplicationException.class)
//  ResponseEntity<ErrorResponse> handleEmployeeApplicationException(EmployeeApplicationException e){
//    ErrorResponse error = new ErrorResponse();
//    error.getErrors().add(new java.lang.Error("", e.getMessage()));
//    return new ResponseEntity<>(error, INTERNAL_SERVER_ERROR);
//  }
//
//  @ExceptionHandler({ NumberFormatException.class})
//  ResponseEntity<ErrorResponse> handleException() {
//    ErrorResponse error = new ErrorResponse();
//    error.getErrors().add(new java.lang.Error("", ErrorMessages.INVALID_EMPLOYEE_ID));
//    return new ResponseEntity<>(error, BAD_REQUEST);
//  }


}