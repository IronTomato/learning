package org.wnb.api.response;

public enum ErrorType {

    Common_Success("0000","cheng gong"),
    Common_EncodeError("0001","encode error"),
    UserNotExist("001","User not exist"),
    EncodeError("002","Encode error")
    ;
    private String code;
    private String message;
    private ErrorType(String code,String message){
        this.code = code;
        this.message = message;
    }
    
    public String getCode(){
        return code;
    }
    
    public String getMessage(){
        return message;
    }
}
