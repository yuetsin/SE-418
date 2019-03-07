package com.yue.wordladder.res;

import java.io.*;
import java.util.regex.Pattern;

public class ResourceUtil {


    public static Reader getResourceReader(String name) throws FileNotFoundException{
        InputStream is = null;
        try {
            is = ResourceUtil.class.getClassLoader().getResourceAsStream(getCPResourcePath(name));
            if (is == null) {
                is = new FileInputStream(new File(name));
            }
            return new InputStreamReader(is);
        }
        catch (FileNotFoundException ex){
            if(null != is){
                try {
                    is.close();
                }
                catch (IOException ex2){
                    throw new RuntimeException(ex2);
                }
            }

            throw ex;
        }
    }

    public static String getCPResourcePath(String name) {
        if (!"/".equals(File.separator)) {
            return name.replaceAll(Pattern.quote(File.separator), "/");
        }
        return name;
    }
}