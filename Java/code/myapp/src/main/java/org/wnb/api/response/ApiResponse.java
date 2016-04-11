package org.wnb.api.response;

public class ApiResponse {

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
     * @param resCode
     *            the resCode to set
     */
    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    /**
     * @param resMsg
     *            the resMsg to set
     */
    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public static class Error extends ApiResponse {

        public static Error create(ErrorType errorType) {
            Error res = new Error();
            res.setResCode(errorType.getCode());
            res.setResMsg(errorType.getMessage());
            return res;
        }

    }

    public static class Normal<T> extends ApiResponse {
        protected T resData;

        public T getResData() {
            return resData;
        }

        public void setResData(T resData) {
            this.resData = resData;
        }

        public static <T> Normal<T> create(T resData) {
            Normal<T> res = new Normal<T>();
            res.setResData(resData);
            return res;
        }

        public static ApiResponse success() {
            return Error.create(ErrorType.Common_Success);
        }
    }
}
