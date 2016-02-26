package util.test;

import static org.junit.Assert.*;

import org.junit.Test;

import util.Fabonacci;

public class TestFabonacci {

    Fabonacci fab = new Fabonacci();
    
    @Test
    public void testGet1() {
        assertTrue(1 == fab.get_(1).intValue());
        assertTrue(1 == Fabonacci.get(1).intValue());
    }
    
    @Test
    public void testGet3(){
        assertTrue(2 == fab.get_(3).intValue());
        assertTrue(2 == Fabonacci.get(3).intValue());
    }
    
    @Test
    public void testGet10(){
        assertTrue(55 == fab.get_(10).intValue());
        assertTrue(55 == Fabonacci.get(10).intValue());
    }
    
    @Test
    public void testGet1000(){
        System.out.println(fab.get_(1000).toString());
        System.out.println(Fabonacci.get(1000).toString());
    }

}
