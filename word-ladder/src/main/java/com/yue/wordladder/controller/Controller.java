package com.yue.wordladder.controller;
import com.yue.wordladder.ladder.Dictionary;
import com.yue.wordladder.ladder.LadderHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @RequestMapping("/")
    public String IndexPage() {
        return "<h1>Here's my Word Ladder Project.</h1> <h2>Tips</h2> Visit <b> /ladder?start=start_word&end=end_word </b> to use word ladder program.";
    }

    @RequestMapping("/ladder")
    public String FeaturePage(String start, String end) {
        if (start == null || end == null) {
            return "<h2>Invalid Argument.</h2> Visit <b> /ladder?start=start_word&end=end_word </b> to use word ladder program.";
        }
        LadderHelper lh = new LadderHelper();
        Dictionary dict = lh.generateDict();
        String[] rst = lh.calculateLadder(start, end, dict);
        return String.format("<h2>Got it.</h2>You've requested a ladder from <b>%s</b> to <b>%s</b>.", start, end);
    }
}
