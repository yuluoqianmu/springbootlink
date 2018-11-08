package com.maolin.bootlink.exception;

import com.maolin.bootlink.enums.ErrorCodeEnum;

/**
 * Created by shaomaolin on 2018/11/8.
 */
public class MessageException extends RuntimeException {

    private final String errMsg;


    public MessageException(String errorMsg, String sysErrMsg) {
        super(sysErrMsg);
        this.errMsg = errorMsg;
    }

    public MessageException(String sysErrMsg, String errMsg, Throwable cause) {
        super(sysErrMsg, cause);
        this.errMsg = errMsg;
    }

    public MessageException(String errorMsg, Throwable cause) {
        super(cause);
        this.errMsg = errorMsg;
    }

    public String getUserErrMsg() {
        return errMsg;
    }

    public String getSysErrMsg() {
        return getMessage();
    }


}
