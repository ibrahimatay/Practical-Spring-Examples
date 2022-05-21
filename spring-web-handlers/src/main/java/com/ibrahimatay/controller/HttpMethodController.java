package com.ibrahimatay.controller;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static java.lang.String.format;

@Controller
public class HttpMethodController {
    // http://localhost:8080/httpMethod
    // HTTP Method = [GET]
    @GetMapping("/httpMethod")
    @ResponseBody
    public String httpMethod(HttpMethod httpMethod) {
        return format("HTTP Method = [%s]\n", httpMethod);
    }
}
