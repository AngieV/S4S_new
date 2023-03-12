package com.laiunchcode.Songs4Soldiers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// Created by Angela Volluz 2023
//use montserrat Lato or Robato

@Controller
public class S4SController {

    //STATIC RESPONSE
    @GetMapping("hi")
    @ResponseBody
    //indicates request handler to accept get requests
    //params in () indicate the handler is specific to the indicated path 8080/hello
    //returns plain text response; will be replaced w/ templates
    public String hi() {
        return "HI--Songs 4 Soldiers(TBA)";
    }

    @GetMapping("goodbye")
    @ResponseBody
    //indicates request handler to accept get requests
    //params in () indicate the handler is specific to the indicated path 8080/hello
    //returns plain text response; will be replaced w/ templates
    public String goodbye() {
        return "GOODBYE--Songs 4 Soldiers(TBA)";
    }

    //DYNAMIC RESPONSE -takes a query parameter
    //general response replaces GetMapping- accepts both get or post
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    //@GetMapping("hello")
    //params in () indicate the handler is specific to the indicated path 8080//hello?name=S4S
    @ResponseBody
    public String helloQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //PATH PARAMS in DYNAMIC REQUESTS (COOL SHIT!)
    // handles requests hello/S4S
    @GetMapping("hello/{name}")
    @ResponseBody
    //@PathVariable handler looks for requests to hello/{name}
    //{name} as dynamic data becomes part of the path
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    @GetMapping("volunteer")
    public String volunteer() {
        return "volunteer";
    }

    @GetMapping("index")
    public String index() {
        return "index";
    }

}
