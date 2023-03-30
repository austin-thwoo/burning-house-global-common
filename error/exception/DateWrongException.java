package com.codingfist.burninghouseauth.globalCommon.error.exception;


import com.codingfist.burninghouseauth.globalCommon.error.model.ErrorCode;

public class DateWrongException extends BusinessException {
    public DateWrongException(String value) {
        super(value, ErrorCode.DATE_WRONG);
    }
}
