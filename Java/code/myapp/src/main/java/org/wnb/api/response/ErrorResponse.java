package org.wnb.api.response;

public abstract class ErrorResponse extends BaseResponse {

    protected abstract Module getModule();

    public void setResCode(ErrorType errorType) {
        resCode = getModule().getModuleCode() + errorType.getErrorCode();
    }

    public static enum Module {
        Login("01");

        private String moduleCode;

        private Module(String moduleCode) {
            this.moduleCode = moduleCode;
        }

        public String getModuleCode() {
            return moduleCode;
        }
    }
}
