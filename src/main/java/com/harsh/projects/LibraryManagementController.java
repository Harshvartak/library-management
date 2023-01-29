package com.harsh.projects;

import io.micronaut.http.annotation.*;

@Controller("/libraryManagement")
public class LibraryManagementController {

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }
}