package com.yue.wordladder.prac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FeatureController {
    @RequestMapping(value = {"/feature"}, method = RequestMethod.GET)
    public String feature() {
        return "/feature.html";
    }
}