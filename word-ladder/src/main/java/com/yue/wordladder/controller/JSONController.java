package com.yue.wordladder.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yue.wordladder.ladder.Dictionary;
import com.yue.wordladder.ladder.LadderHelper;
import com.yue.wordladder.response.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

@RestController
@RequestMapping("/json")
public class JSONController {
    @RequestMapping("/ladder")
    public ModelAndView GetJSON(String start, String end) {
        return new ModelAndView(new RedirectView(String.format("http://47.103.66.98:8080/practical/json/ladder?start=%s&end=%s", start, end)));
    }
}
