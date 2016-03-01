package designpattern.singleton;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class SingletonFactoryTest {

    @Test
    public void test() {
        Date date1 = (Date)SingletonFactory.getSingleton(Date.class);
        Date date2 = (Date)SingletonFactory.getSingleton(Date.class);
        Date date3 = new Date();
        assertTrue(date1 == date2);
        System.out.println(date1);
        System.out.println(date2);
    }

}
