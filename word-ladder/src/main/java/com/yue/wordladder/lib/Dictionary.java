package com.yue.wordladder.lib;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import com.sun.org.apache.xml.internal.security.Init;

public class Dictionary {


    public Dictionary(String resPath) {
        File file = new File(resPath);
        BufferedReader reader = null;
        int counter = 0;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString;

            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                this.dictionary.add(tempString);
                System.out.println("Get line " + counter + " as " + tempString);
                counter++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(String.format("Error occurred after reading %d lines.", counter));
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                    System.out.println(String.format("Successfully read in %d lines.", counter));
                } catch (IOException e1) {
                    e1.printStackTrace();
                    System.err.println("Failed to close stream.");
                }
            }
        }
    }

    private List<String> dictionary = new ArrayList();


    public List<String> getStringArray() {
        return dictionary;
    }
}
