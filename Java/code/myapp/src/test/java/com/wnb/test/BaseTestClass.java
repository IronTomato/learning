package com.wnb.test;

import org.apache.log4j.Logger;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

public class BaseTestClass {

    protected static final Logger logger = Logger.getRootLogger();
    
    protected int value = getValue("base init");
    
    public BaseTestClass(){
        value = getValue("base construct");
    }
    
    public static int getValue(String message){
        logger.debug(message);;
        return 0;
    }
    
    @Rule
    public TestRule timeoutRule = new Timeout(1000);
}
