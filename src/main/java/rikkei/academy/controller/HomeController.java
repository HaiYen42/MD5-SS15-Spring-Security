package rikkei.academy.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String goHome(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authentication--->"+authentication);
        return "home/home";
    }
}
