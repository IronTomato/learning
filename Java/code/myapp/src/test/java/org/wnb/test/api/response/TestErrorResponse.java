package org.wnb.test.api.response;

import static org.junit.Assert.*;

import org.junit.Test;
import org.wnb.api.response.BaseResponse;
import org.wnb.api.response.ErrorResponse;
import org.wnb.api.response.ErrorType;

public class TestErrorResponse {

    @Test
    public void test() {
        BaseResponse res = LoginErrorResponse.create(LoginErrorResponse.LoginErrorType.RequireField, "");
        System.out.println(res.getResCode());
        
    }
    
    public static class LoginErrorResponse extends ErrorResponse{

        @Override
        protected Module getModule() {
            return Module.Login;
        }
        
        public static LoginErrorResponse create(LoginErrorType errorType,String msg){
            LoginErrorResponse res = new LoginErrorResponse();
            res.setResCode(errorType);
            res.setResMsg(msg);
            return res;
        }

        
        public static enum LoginErrorType implements ErrorType{
            RequireField("01");

            private String errorCode;
            
            private LoginErrorType(String errorCode){
                this.errorCode = errorCode;
            }
            @Override
            public String getErrorCode() {
                return errorCode;
            }
            
        }
        
    }

}
