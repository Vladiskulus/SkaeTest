package com.iambulance.skai.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FileUploaderController {

    @GetMapping("")
    public String showUploadForm() {
        return "form";
    }
}