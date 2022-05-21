package com.ibrahimatay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Controller
public class ServletController {
    // http://localhost:8080/servletRequest
    // Retrieved request on server = [localhost:8080]
    @GetMapping("/servletRequest")
    @ResponseBody
    public String servletRequest(ServletRequest servletRequest) {
        return String.format(
                "Retrieved request on server = [%s:%d]\n",
                servletRequest.getServerName(),
                servletRequest.getServerPort()
        );
    }

    // http://localhost:8080/servletReqResp
    // Retrieved request on server = [localhost:8080]
    @GetMapping("/servletReqResp")
    @ResponseBody
    public void servletReqResp(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        servletResponse.getOutputStream().println(
                String.format(
                        "Retrieved request on server = [%s:%d]\n",
                        servletRequest.getServerName(),
                        servletRequest.getServerPort()
                )
        );
    }
}
