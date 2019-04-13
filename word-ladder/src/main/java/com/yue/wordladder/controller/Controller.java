package com.yue.wordladder.controller;
import com.yue.wordladder.ladder.Dictionary;
import com.yue.wordladder.ladder.LadderHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

@RestController
public class Controller {

    @RequestMapping("/ladder")
    public String FeaturePage(String start, String end) {
        if (start == null || end == null) {
            return "<h2>Invalid Argument.</h2> Visit <b> /ladder?start=start_word&end=end_word </b> to use word ladder program.";
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
            return String.format("<h2>So Sorry... No Ladder Found.</h2>Something horrible happens: <b><font color=\"#FF0000\">%s</font></b> Sincerely apologize for inconvenience.<br><h3><b>Error Stack Trace: </b></h3><br>%s", e.toString(), sw.toString());
        }
        return String.format("<h2>Got it.</h2>You've requested a ladder from <b>%s</b> to <b>%s</b>. <br>%s", start, end, String.join("<b> => </b>", rst));
    }
}

