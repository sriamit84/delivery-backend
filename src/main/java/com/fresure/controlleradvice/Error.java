package com.fresure.controlleradvice;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.lang.Nullable;

public class Error {

  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private final String fieldName;

  private final String message;

  public Error(String fieldName, String message) {
    this.fieldName = fieldName;
    this.message = message;
  }

  public String getFieldName() {
    return fieldName;
  }

  public String getMessage() {
    return message;
  }
}