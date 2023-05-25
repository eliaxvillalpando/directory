package com.iudc;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class ControladorPrincipal {
    
    @PostMapping("/doLogin")
    public String viewHomePage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {

            return "login";

        }

        return "redirect:/administrar";
    }

    /*
    @PostMapping("/login_exitoso")
    public String loginSuccessHandler() {
        System.out.println("Login exitoso");

        return "index";
        
    }*/

}
