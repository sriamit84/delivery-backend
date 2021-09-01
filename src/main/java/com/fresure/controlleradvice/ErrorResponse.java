package com.fresure.controlleradvice;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponse {

  private List<java.lang.Error> errors = new ArrayList<>();

  public List<java.lang.Error> getErrors() {
    return errors;
  }

  public void setErrors(List<java.lang.Error> errors) {
    this.errors = errors;
  }
}