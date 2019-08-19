package com.aerotravel.flightticketbooking.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }


    @GetMapping("/login")
    public String showLoginPage(){
        return "login/login";
    }



    @GetMapping("fancy")
    public String showLoginPage1(){
        return "index";}

}
