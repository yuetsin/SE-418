package com.yue.wordladder.controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class ConsoleController {
    @RequestMapping("/console")
    @PreAuthorize("hasRole('ADMIN')")
    public String console() {
        return "/console.html";
    }
}
