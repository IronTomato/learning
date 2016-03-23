package org.wnb.api.response;

public class BaseResponse {

    protected String resCode;
    
    protected String resMsg;

    /**
     * @return the resCode
     */
    public String getResCode() {
        return resCode;
    }

    /**
     * @return the resMsg
     */
    public String getResMsg() {
        return resMsg;
    }

    /**
     * @param resCode the resCode to set
     */
    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    /**
     * @param resMsg the resMsg to set
     */
    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }
    
    
}
