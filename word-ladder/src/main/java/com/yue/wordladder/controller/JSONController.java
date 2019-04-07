package com.yue.wordladder.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yue.wordladder.ladder.Dictionary;
import com.yue.wordladder.ladder.LadderHelper;
import com.yue.wordladder.response.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;



@RestController
@RequestMapping("/json")
public class JSONController {
    @RequestMapping("/ladder")
    public Response GetJSON(String start, String end) {
        System.out.println(String.format("Get a JSON Request from %s to %s", start, end));
        Response resp = new Response();
        if (start == null || end == null) {
            resp.status = "bad parameters";
            return resp;
        }
        LadderHelper lh = new LadderHelper();
        Dictionary dict = lh.generateDict();
        List<String> rst;
        try {
            rst = lh.calculateLadder(start, end, dict).get(0);
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            resp.status = "no possible ladder";
            return resp;
        }

        resp.status = "ok";
        resp.ladders = rst.toArray(new String[0]);
        return resp;
    }
}
