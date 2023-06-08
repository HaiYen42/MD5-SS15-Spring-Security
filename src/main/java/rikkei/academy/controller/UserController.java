package rikkei.academy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth/")
public class UserController {
    @GetMapping("user")
    public String profileUser(){
     return "user/user";
    }
    @GetMapping("admin")
    public String profileAdmin(){
        return "user/admin";
    }
}
