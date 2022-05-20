package com.ibrahimatay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class IndexController {
    // http://localhost:8080/actionA
    // Handled with @GetMapping("/actionA")
    @GetMapping("/actionA")
    @ResponseBody
    public String actionA() {
        return "Handled with @GetMapping(\"/actionA\")";
    }

    // http://localhost:8080/actionB
    // Handled with @RequestMapping(method ={ RequestMethod.GET, RequestMethod.POST}, path = "/actionB")
    @RequestMapping(method = { RequestMethod.GET, RequestMethod.POST}, path = "/actionB")
    @ResponseBody
    public String actionB() {
        return "Handled with @RequestMapping(method ={ RequestMethod.GET, RequestMethod.POST}, path = \"/actionB\")";
    }

    // http://localhost:8080/actionC
    // Handled with @RequestMapping(path = "/actionC")
    @RequestMapping(path = "/actionC")
    @ResponseBody
    public String actionC() {
        return "Handled with @RequestMapping(path = \"/actionC\")";
    }

    // http://localhost:8080/actionD?name=ibrahim
    // Name:ibrahim - City:Istanbul
    // http://localhost:8080/actionD?name=ibrahim&city=Ankara
    // Name:ibrahim - City:Ankara
    @GetMapping(path = "/actionD")
    @ResponseBody
    public String actionD(@RequestParam("name") String name, @RequestParam(value = "city", required = false, defaultValue = "Istanbul") String city) {
        return String.format("Name:%s - City:%s", name, city);
    }

    // http://localhost:8080/actionE?cities=Istanbul,Ankara,Izmir
    // cities:Istanbul,Ankara,Izmir
    @GetMapping(path = "/actionE")
    @ResponseBody
    public String actionE(@RequestParam Map<String, String> parameters) {
        return
        parameters.entrySet().stream()
                .map(entry -> String.format("%s:%s", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(", "));
    }

    // http://localhost:8080/actionF?cities=Istanbul,Ankara,Izmir
    // Istanbul, Ankara, Izmir
    @GetMapping("/actionF")
    @ResponseBody
    public String actionF(@RequestParam("cities")List<String> cities) {
        return String.join(", ", cities);
    }

    // http://localhost:8080/actionG/countries/turkey/istanbul
    // Country:turkey - City:istanbul
    @GetMapping("/actionG/countries/{country}/{city}")
    @ResponseBody
    public String actionG(@PathVariable("country")String country, @PathVariable("city")String city){
        return String.format("Country:%s - City:%s", country, city);
    }

    // http://localhost:8080/actionH/countries/turkey/istanbul
    // Country:turkey - City:istanbul
    // http://localhost:8080/actionH/countries/turkey
    // Country:turkey - City:Ankara
    @GetMapping({"/actionH/countries/{country}/{city}", "/actionH/countries/{country}"})
    @ResponseBody
    public String actionH(@PathVariable("country")String country, @PathVariable(value = "city") Optional<String> city) {
        return String.format("Country:%s - City:%s", country, city.orElse("Ankara"));
    }

    // http://localhost:8080/actionK/countries/turkey/cities/istanbul/zip/34300
    // country:turkey, city:istanbul, code:34300
    @GetMapping("/actionK/countries/{country}/cities/{city}/zip/{code}")
    @ResponseBody
    public String actionK(@PathVariable Map<String, String> parameters) {
        return
                parameters.entrySet().stream()
                        .map(entry -> String.format("%s:%s", entry.getKey(), entry.getValue()))
                        .collect(Collectors.joining(", "));
    }

    // http://localhost:8080/actionM/people/firstname=ibrahim;lastname=atay
    // ibrahim atay
    @GetMapping("/actionM/people/{people}")
    @ResponseBody
    public String actionM(@MatrixVariable("firstname")String firstName, @MatrixVariable("lastname")String lastName) {
        return String.format("%s %s", firstName, lastName);
    }
}
