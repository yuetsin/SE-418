package com.yue.wordladder;

import com.yue.wordladder.controller.Controller;
import com.yue.wordladder.controller.CustomErrorController;
import com.yue.wordladder.controller.JSONController;
import com.yue.wordladder.exceptions.LadderNotFoundException;
import com.yue.wordladder.exceptions.WordNotFoundException;
import com.yue.wordladder.ladder.Dictionary;
import com.yue.wordladder.ladder.LadderHelper;
import com.yue.wordladder.res.ResourceUtil;
import com.yue.wordladder.utils.Printer;
import com.yue.wordladder.utils.Reverser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.util.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WordLadderApplicationTests {

    LadderHelper lh = new LadderHelper();
    Dictionary dict = lh.generateDict();

    @Test
    public void startServer() {
        WordLadderApplication wLA = new WordLadderApplication();
        wLA.main(new String[]{});
    }

    @Test
    public void testControllers() {
        Controller ct = new Controller();
//        CustomErrorController eCT = new CustomErrorController();
        ct.IndexPage();
        ct.FeaturePage("hit", "dog");
        ct.FeaturePage("", "NotAWordAnyWay");
    }

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

    @Test
    public void testReverser() {
        Reverser reverser = new Reverser();
        Assert.assertEquals(reverser.reverseList(Arrays.asList("dog", "dig", "dit", "hit")), Arrays.asList("hit", "dit", "dig", "dog"));
    }


    @Test
    public void testPrinter() {
        Printer printer = new Printer();
        Set<String> set = new HashSet<>(Arrays.asList("smile", "smiler", "sailer", "mailer", "maimer", "mammer", "hammer"));
        Queue<String> queue = new LinkedList<>(Arrays.asList("smile", "smiler", "sailer", "mailer", "maimer", "mammer", "hammer"));
        printer.printSet(set);
        printer.printQueue(queue);
    }

    @Test
    public void testNormallyReadResources() {
        ResourceUtil rU = new ResourceUtil();
        try {
            rU.getResourceReader("static/dictionary.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(expected = FileNotFoundException.class)
    public void testAbnormallyReadResources() throws FileNotFoundException {
        ResourceUtil rU = new ResourceUtil();
        rU.getResourceReader("NonExistResFile");
    }

    @Test
    public void checkJSONOutput()  {
        JSONController ct = new JSONController();
        System.out.println(ct.GetJSON("smile", "hammer"));
    }

    @Test(expected = LadderNotFoundException.class)
    public void raiseLadderNotFoundException() throws LadderNotFoundException {
        throw new LadderNotFoundException("LadderNotFoundExceptionRaised");
    }


    @Test(expected = WordNotFoundException.class)
    public void raiseWordNotFoundException() throws WordNotFoundException {
        throw new WordNotFoundException("WordNotFoundExceptionRaised");
    }
}
