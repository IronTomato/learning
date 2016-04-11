package org.wnb.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class UseBaseTestClass extends BaseTestClass{
    
    
    protected int value = getValue("extend init");
    
    public UseBaseTestClass() {
        value= getValue("extend construct");
    }

    @Test
    public void test1() {
//        logger.debug(logger.getName());
    }
    
    @Test
    public void test2() throws InterruptedException{
//        Thread.currentThread().sleep(5000);
    }

}
