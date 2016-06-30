package com.wnb.test;

import static org.junit.Assert.*;

import java.io.OutputStreamWriter;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.junit.Test;

public class Log4jTest {

    @Test
    public void test() {
        Logger logger = Logger.getLogger(this.getClass());
//        ConsoleAppender stdout = new ConsoleAppender();
//        stdout.setName("stdout");
//        stdout.setLayout(new SimpleLayout());
////        stdout.setWriter(new OutputStreamWriter(System.out));
//        stdout.setTarget("System.out");
//        logger.addAppender(stdout);
        logger.info("xxxxx");
//        logger.getRootLogger().info("xxxxx");
    }

}
