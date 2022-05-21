package com.ibrahimatay.controller;

import com.ibrahimatay.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AnyTypeController {
    // http://localhost:8080/anyTypeAction?firstName=ibrahim&lastName=atay
    // firstName = [ibrahim], lastName = [atay]
    @GetMapping("/anyTypeAction")
    @ResponseBody
    public String anyTypeAction(String firstName, String lastName) {
        return String.format(
                "firstName = [%s], lastName = [%s]\n",
                firstName, lastName
        );
    }

    // http://localhost:8080/anyTypeActionWithModel?firstName=ibrahim&lastName=atay
    // Person(firstName=ibrahim, lastName=atay)
    @GetMapping("/anyTypeActionWithModel")
    @ResponseBody
    public String anyTypeActionWithModel(Person person) {
        return person.toString();
    }

}
