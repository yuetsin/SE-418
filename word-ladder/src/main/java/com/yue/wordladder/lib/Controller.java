package com.yue.wordladder.lib;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @RequestMapping("/")
    public String IndexPage() {
        return "<h1>Index Page</h1> <h2>Tips</h2> Visit <b> /ladder?start=start_word&end=end_word </b> to use word ladder program.";
    }

    @RequestMapping("/ladder")
    public String FeaturePage(String start, String end) {
        LadderHelper lh = new LadderHelper();
        Dictionary dict = lh.generateDict();
        String[] rst = lh.getLadder(start, end, dict);
        return rst.toString();
    }
}
