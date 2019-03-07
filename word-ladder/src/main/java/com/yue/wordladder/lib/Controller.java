package com.yue.wordladder.lib;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @RequestMapping("/")
    public String IndexPage() {
        return "<h1>Index Page</h1> <h2>Tips</h2> Visit <b> /ladder?start=start_word&end=end_word </b> to use word ladder program.";
    }

    @RequestMapping("/ladder")
    public String FeaturePage() {
        return "Here you are.";
    }
}
