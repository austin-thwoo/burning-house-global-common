package globalCommon.error.exception;

import globalCommon.error.model.ErrorCode;
import org.springframework.http.HttpStatus;


public class BusinessException extends RuntimeException {


    private ErrorCode errorCode;
    private HttpStatus httpStatus;

    public BusinessException() {

        super(ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
        this.errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
    }

    public BusinessException(String message, ErrorCode errorCode) {


        super(message);
        this.errorCode = errorCode;

    }
    public BusinessException(String message, ErrorCode errorCode, HttpStatus httpStatus) {

        super(message);
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }


//    public BusinessException(List<String> messages, ErrorCode errorCode) {//
//        for (String messsage : messages) {
//            super(messsage);
//            this.errorCode = errorCode;
//        }

//    }


    public BusinessException(ErrorCode errorCode) {

        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }




    public ErrorCode getErrorCode() {

        return errorCode;

    }

}
