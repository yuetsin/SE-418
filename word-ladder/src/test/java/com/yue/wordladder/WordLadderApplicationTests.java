package com.yue.wordladder;

import com.yue.wordladder.exceptions.LadderNotFoundException;
import com.yue.wordladder.exceptions.WordNotFoundException;
import com.yue.wordladder.ladder.Dictionary;
import com.yue.wordladder.ladder.LadderHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WordLadderApplicationTests {

    LadderHelper lh = new LadderHelper();
    Dictionary dict = lh.generateDict();

    @Test

    public void testCorrectLadder() {
        Assert.assertEquals(lh.calculateLadder("hit", "dog", dict).get(0), Arrays.asList("hit", "dit", "dig", "dog"));
        Assert.assertEquals(lh.calculateLadder("smile", "dog", dict).get(0), Arrays.asList("smile", "mile", "mil", "mig", "dig", "dog"));
        Assert.assertEquals(lh.calculateLadder("smile", "hammer", dict).get(0), Arrays.asList("smile", "smiler", "sailer", "mailer", "maimer", "mammer", "hammer"));
    }

    @Test(expected = LadderNotFoundException.class)
    public void testLadderNotFoundException() {
        lh.calculateLadder("eat", "sequence", dict);
    }

    @Test(expected = WordNotFoundException.class)
    public void testInvalidArguments() {
        lh.calculateLadder(null, "wheat", dict);
        lh.calculateLadder("smile", null, dict);
        lh.calculateLadder("AnyWayNotAWord", "smile", dict);
    }
}
