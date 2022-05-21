package com.ibrahimatay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UriComponentsBuilderController {
    // http://localhost:8080/uriComponentsBuilderAction
    // Created request from original request = [https://localhost:8080/uriComponentsBuilderAction/uriComponentsBuilderAction?null&firstName=ibrahim&lastName=atay]
    @GetMapping("/uriComponentsBuilderAction")
    @ResponseBody
    public String uriComponentsBuilderAction(HttpServletRequest request) {
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(request.getRequestURL().toString() + "?" + request.getQueryString())
                .scheme("https")
                .path("/uriComponentsBuilderAction")
                .replaceQueryParam("firstName", "ibrahim")
                .replaceQueryParam("lastName", "atay")
                .build();

        return String.format(
                "Created request from original request = [%s]\n",
                uriComponents
        );
    }
}
