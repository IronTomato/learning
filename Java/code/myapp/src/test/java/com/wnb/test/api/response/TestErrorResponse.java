package com.wnb.test.api.response;

import static org.junit.Assert.*;

import org.junit.Test;
import com.wnb.api.response.ApiResponse;
import com.wnb.api.response.ErrorType;

public class TestErrorResponse {

    @Test
    public void test() {
        ApiResponse res = ApiResponse.Error.create(ErrorType.Common_Success);
        ApiResponse normalRes = ApiResponse.Normal.success();

    }

}
