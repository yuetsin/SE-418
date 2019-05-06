package com.yue.wordladder.prac.ladder;
import com.yue.wordladder.prac.res.ResourceUtil;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Dictionary {

    public static String readResource(String path) throws FileNotFoundException {
        ResourceUtil ru = new ResourceUtil();

        Reader reader = null;
        try {
            reader = ru.getResourceReader(path);
            if (reader == null) {
                throw new FileNotFoundException("no file found" + path);
            }
            Scanner s = new Scanner(reader).useDelimiter("\\A");
            return s.hasNext() ? s.next() : "";
        }
        finally {
            if(null != reader){
                try {
                    reader.close();
                }
                catch (IOException ex2){
                    throw new RuntimeException(ex2);
                }
            }
        }
    }

    public Dictionary(String resPath) {
//        InputStream in = this.getClass().getResourceAsStream("/static/dictionary.txt");
        try {
            String rawStr = this.readResource(resPath);
            this.dictionary = rawStr.split("\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("Failed to load dictionary resources.");
        }
    }



    private String dictionary[] = null;


    public String[] getStringArray() {
        return dictionary;
    }
}
