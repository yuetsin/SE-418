package com.yue.wordladder.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConsoleController {
    @RequestMapping("/console")
    public String console() {
        return "console";
    }
}
