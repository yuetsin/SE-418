package com.yue.wordladder.controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ConsoleController {
    @RequestMapping("/console")
    @PreAuthorize("hasRole('ADMIN')")
    public String console() {
        return "console";
    }
}
