package com.wnb.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class CommonsLoggingTest {

    private final Log log = LogFactory.getLog(this.getClass());

    @Rule
    public TestRule rule = new TestRule() {

        @Override
        public Statement apply(Statement base, Description description) {
            return new Statement() {

                @Override
                public void evaluate() throws Throwable {
                    try {
                        base.evaluate();
                    } catch (Throwable e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(e.getMessage()).append("\n");
                        Arrays.asList(e.getStackTrace()).stream().map(s -> ("\tat " + s.toString() + "\n"))
                                .forEach(sb::append);
                        log.error(sb.toString());
                        throw e;
                    }
                }
            };
        }
    };

    @Test
    public void test() {
        // log.debug("commons logging");
        assertEquals(1, 2);
    }

}
