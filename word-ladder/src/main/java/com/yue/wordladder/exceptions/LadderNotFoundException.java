package com.yue.wordladder.exceptions;

public class LadderNotFoundException extends RuntimeException {
    private String retCd;  //异常对应的返回码
    private String msgDes;  //异常对应的描述信息

    public LadderNotFoundException() {
        super();
    }

    public LadderNotFoundException(String message) {
        super(message);
        msgDes = message;
    }

    public LadderNotFoundException(String retCd, String msgDes) {
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
