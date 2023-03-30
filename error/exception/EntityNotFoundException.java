<<<<<<< HEAD
package com.codingfist.burninghouseuser.golobalCommon.error.exception;

import com.codingfist.burninghouseuser.globalcommon.globalcommon.error.exception.BusinessException;
import com.codingfist.burninghouseuser.globalcommon.globalcommon.error.exception.GlobalExceptionHandler;
import com.codingfist.burninghouseuser.globalcommon.globalcommon.error.model.ErrorCode;
=======
package com.codingfist.burninghouseauth.globalCommon.error.exception;

import com.codingfist.burninghouseauth.globalCommon.error.model.ErrorCode;
>>>>>>> origin/master

public class EntityNotFoundException extends BusinessException {

    public EntityNotFoundException(String message) {
        super(message, ErrorCode.ENTITY_NOT_FOUND);
    }

    public EntityNotFoundException() {
        super("ddd", ErrorCode.ENTITY_NOT_FOUND);

        GlobalExceptionHandler ee = new GlobalExceptionHandler();

        ee.handleAccessDeniedException();
    }
}