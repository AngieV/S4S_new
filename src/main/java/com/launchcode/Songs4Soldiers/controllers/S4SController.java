package com.launchcode.Songs4Soldiers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    /*
    //@GetMapping("hello")
    //general response replaces GetMapping- accepts both get or post
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    //params in () indicate the handler is specific to the indicated path 8080//hello?name=S4S
    @ResponseBody
    public String helloQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }
    */
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloQueryParam(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
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

    @GetMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("about")
    public String about(){
        return "about";
    }

    @GetMapping("shop")
    public String merchandise(Model model) {
        String title="Official Merchandise";
        model.addAttribute("title", title);
        return "merch";
    }

    @GetMapping("tickets")
    public String tickets(Model model) {
        String title="Tickets";
        model.addAttribute("title", title);
        return "tickets";
    }

    @GetMapping("volunteer")
    public String volunteer(Model model) {
        String title="Volunteer";
        model.addAttribute("title", title);
        List<String> days=new ArrayList<>();
        days.add("Friday Only");
        days.add("Saturday Only");
        days.add("Weekend Pass");
        model.addAttribute("days", days);
        return "volunteer";
    }

    @GetMapping("contact")
    public String contact(Model model) {
        String title="Contact Us";
        model.addAttribute("title", title);
        return "contact";
    }

/*    moved to events controller   */

/*    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "event")
    public String eventQueryParam(@RequestParam String name, Model model) {
        String thankYou = "Thank You, " + name + "!";
        model.addAttribute("thankYou", thankYou);
        return "registered";
    }

    @GetMapping("registered/{eventName}")
    @ResponseBody
    //@PathVariable handler looks for requests to registered/{eventName}
    //{eventName} as dynamic data becomes part of the path
    public String event_PathParam(@PathVariable String eventName){
        return "You have registered for " + eventName + "!";
    }

 */
}
