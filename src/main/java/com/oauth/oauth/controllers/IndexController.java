package com.oauth.oauth.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class IndexController {

    @GetMapping("/login")
    public String login(){
        return "login"; // -\__(::)__/
    }

    @GetMapping("/")
    public String dashboard(Principal principal){
        String username = principal.getName();
        System.err.println(username +" ---- " + principal.toString());
        return "dashboard/index"; // -\__:)__/
    }
}
