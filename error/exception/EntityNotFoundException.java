package globalCommon.error.exception;

import globalCommon.error.exception.BusinessException;
import globalCommon.error.exception.GlobalExceptionHandler;
import globalCommon.error.model.ErrorCode;

import globalCommon.error.model.ErrorCode;

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