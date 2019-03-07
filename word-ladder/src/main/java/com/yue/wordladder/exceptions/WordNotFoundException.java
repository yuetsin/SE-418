package com.yue.wordladder.exceptions;

public class WordNotFoundException extends RuntimeException {

    private String retCd;  //异常对应的返回码
    private String msgDes;  //异常对应的描述信息

    public WordNotFoundException() {
        super();
    }

    public WordNotFoundException(String message) {
        super(message);
        msgDes = message;
    }

    public WordNotFoundException(String retCd, String msgDes) {
        super();
        this.retCd = retCd;
        this.msgDes = msgDes;
    }

    public String getRetCd() {
        return retCd;
    }

    public String getMsgDes() {
        return msgDes;
    }
}

/*
    作者：Hoking
    来源：CSDN
    原文：https://blog.csdn.net/mahoking/article/details/45064259
    版权声明：本文为博主原创文章，转载请附上博文链接！
*/