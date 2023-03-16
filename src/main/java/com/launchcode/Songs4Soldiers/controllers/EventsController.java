package com.launchcode.Songs4Soldiers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EventsController {

    //make the list global
    private static List<String> events=new ArrayList<>();

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

    /*@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "events")
    public String eventsQueryParam(@RequestParam String name, Model model) {
        String register = "Thank You for registering " + name + "!";
        model.addAttribute("register", register);
        return "events";
    }*/

/*    //PATH PARAMS in DYNAMIC REQUESTS (COOL SHIT!)
    // handles requests events
    @GetMapping("events/{name}")
    @ResponseBody
    //@PathVariable handler looks for requests to events/{name}
    //{name} as dynamic data becomes part of the path
    public String helloWithPathParam(@PathVariable String name){
        return "Thank You for registering " + name + "!";
    }*/

    @GetMapping("event/yoga4soldiers")
    public String yoga4soldiers(Model model){
        String title="Yoga4Soldiers";
        model.addAttribute("title", title);
        return "event/yoga4soldiers";
    }

    @GetMapping("event/golf")
    public String golf(Model model){
        String title="S4S Annual Golf Tournament";
        model.addAttribute("title", title);
        return "event/golf";
    }

    @GetMapping("event/yardsale")
    public String yardsale(Model model){
        String title="S4S Yard Sale";
        model.addAttribute("title", title);
        return "event/yardsale";
    }

    @GetMapping("event/workout")
    public String workout(Model model){
        String title="Hero Workout";
        model.addAttribute("title", title);
        return "event/workout";
    }

    @GetMapping("signup")
    public String signup(Model model){
        String title="Sign Up";
        model.addAttribute("title", title);
        return "signup";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "register")
    public String eventRegisterQuery(@RequestParam String name, @RequestParam String email, Model model) {
        String register = "Thank You for registering " + name + "! You will receive an e-mail at " + email + "shortly to confirm. ";
        model.addAttribute("register", register);
        return "signup";
    }

/*    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "signup")
    public String signupQueryParam(@RequestParam String name, Model model) {
        String register = "Thank You for registering " + name + "!";
        model.addAttribute("register", register);
        return "register";
    }*/
}