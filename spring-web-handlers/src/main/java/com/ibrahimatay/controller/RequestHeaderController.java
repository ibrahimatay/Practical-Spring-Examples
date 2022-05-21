package com.ibrahimatay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.Optional;

@Controller
public class RequestHeaderController {
    @GetMapping("/requestHeaderAction")
    @ResponseBody
    public String requestHeaderAction(@RequestHeader("Accept-Version") String acceptVersion) {
        return String.format("Received request with Accept-Version = [%s]\n", acceptVersion);
    }

    // http://localhost:8080/requestHeaderActionWithDefault
    // Received request with Accept-Version = [N/A]
    @GetMapping("/requestHeaderActionWithDefault")
    @ResponseBody
    public String requestHeaderActionWithDefault(@RequestHeader(value = "Accept-Version", required = false, defaultValue = "N/A") String acceptVersion) {
        return String.format("Received request with Accept-Version = [%s]\n", acceptVersion);
    }

    // http://localhost:8080/requestHeaderActionWithOptional
    // Received request with Accept-Version = [N/A]
    @GetMapping("/requestHeaderActionWithOptional")
    @ResponseBody
    public String requestHeaderActionWithOptional(@RequestHeader("Accept-Version") Optional<String> acceptVersion) {
        return String.format("Received request with Accept-Version = [%s]\n", acceptVersion.orElse("N/A"));
    }

    @GetMapping("/requestHeadersAction")
    @ResponseBody
    public String requestHeadersAction(@RequestHeader Map<String, String> headers) {
        return String.format("Received request with headers = [%s]\n", headers);
    }
}
