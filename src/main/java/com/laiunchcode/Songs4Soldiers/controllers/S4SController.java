package com.laiunchcode.Songs4Soldiers.controllers;

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
        return "volunteer";
    }

    @GetMapping("contact")
    public String contact(Model model) {
        String title="Contact Us";
        model.addAttribute("title", title);
        return "contact";
    }

    @GetMapping("events")
    public String events(Model model) {
        String title="Events";
        model.addAttribute("title", title);
        List<String> events=new ArrayList<>();
        events.add("Yoga4Soldiers");
        events.add("Maupin Memorial Hero Workout");
        events.add("Songs4Soldiers Yard Sale");
        events.add("2023 S4S Golf Tournament");
        model.addAttribute("events", events);
        model.addAttribute("signup", "signup");
        return "events";
    }

    @GetMapping("events/yoga4soldiers")
        public String yoga4soldiers(){
        return "yoga4soldiers";
    }

    @GetMapping("events/golf")
    public String golf(){
        return "golf";
    }

    @GetMapping("events/yardsale")
    public String yardsale(){
        return "yardsale";
    }

    @GetMapping("events/workout")
    public String workout(){
        return "workout";
    }

    @GetMapping("signup")
    public String signup(){
        return "signup";
    }

}
