package com.launchcode.Songs4Soldiers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EventsController {

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

    @PostMapping
    public String eventRegister(@RequestParam String name){
        return "Thank you, " + name + "!";
    }

    /*@PostMapping
    @ResponseBody
    public String eventRegister(@RequestParam String name){
    return "event/";
        return "Thank you, " + name + "!";
    }*/

    @GetMapping("event/yoga4soldiers")
    public String yoga4soldiers(){
        return "event/yoga4soldiers";
    }

    @GetMapping("event/golf")
    public String golf(){
        return "event/golf";
    }

    @GetMapping("event/yardsale")
    public String yardsale(){
        return "event/yardsale";
    }

    @GetMapping("event/workout")
    public String workout(){
        return "event/workout";
    }

    @GetMapping("signup")
    public String signup(Model model){
        String title="Sign Up";
        model.addAttribute("title", title);
        return "signup";
    }
}
