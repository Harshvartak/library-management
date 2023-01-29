package com.harsh.projects.controller;

import io.micronaut.http.annotation.*;

@Controller("/library")
public class LibraryManagementController {

  @Get(uri = "/", produces = "text/plain")
  public String index() {
    return "Example Response";
  }
}