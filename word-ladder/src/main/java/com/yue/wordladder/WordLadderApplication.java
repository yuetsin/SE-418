package com.yue.wordladder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.yue.wordladder.lib.*;

@SpringBootApplication
public class WordLadderApplication {

    public static void main(String[] args) {
        SpringApplication.run(WordLadderApplication.class, args);
        LadderHelper ld = new LadderHelper();
        ld.testFunction();
    }
}
