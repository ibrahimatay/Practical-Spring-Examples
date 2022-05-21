package com.ibrahimatay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Optional;

import static java.lang.String.format;

@Controller
public class HttpSessionController {
    // http://localhost:8080/sessionCounter
    // Counter = [null]
    // Counter = [1]
    // Counter = [2]
    // Counter = [3]
    @GetMapping("/sessionCounter")
    @ResponseBody
    public String sessionCounter(HttpSession session) {
        Integer counter = (Integer) session.getAttribute("counter");
        if(counter == null){
            session.setAttribute("counter", 0);
        } else {
            session.setAttribute("counter", (counter+1));
        }

        return format("Counter = [%d]\n", counter);
    }
}
