package com.maolin.bootlink.exception;

import com.maolin.bootlink.enums.ErrorCodeEnum;

/**
 * Created by shaomaolin on 2018/11/8.
 */
public class MessageException extends Exception {

    private final String errMsg;

    private final ErrorCodeEnum errCode;

    public MessageException(ErrorCodeEnum errorCode,String errorMsg, String sysErrMsg) {
        super(sysErrMsg);
        this.errMsg = errorMsg;
        this.errCode = errorCode;
    }

    public MessageException(ErrorCodeEnum errorCode, String sysErrMsg, String userErrMsg, Throwable cause) {
        super(sysErrMsg, cause);
        this.errMsg = userErrMsg;
        this.errCode = errorCode;
    }

    public MessageException(ErrorCodeEnum errorCode, String sysErrMsg) {
        super(sysErrMsg);
        this.errMsg = null;
        this.errCode = errorCode;
    }

    public ErrorCodeEnum getErrorCode() {
        return errCode;
    }

    public String getUserErrMsg() {
        return errMsg;
    }

    public String getSysErrMsg() {
        return getMessage();
    }


}
