package com.codingfist.burninghouseuser.globalcommon.globalcommon.error.exception;


import com.codingfist.burninghouseuser.globalcommon.globalcommon.error.model.ErrorCode;

public class DateWrongException extends BusinessException {
    public DateWrongException(String value) {
        super(value, ErrorCode.DATE_WRONG);
    }
}
