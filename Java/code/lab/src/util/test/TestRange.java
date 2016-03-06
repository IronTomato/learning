package util.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import util.Range;

public class TestRange {

    @Test
    public void testBuild1() {
        Range rg = Range.from(1).to(100).byDefault();
        assertNotNull(rg);
    }

    @Test
    public void testBuild2() {
        Range rg = Range.from(0).to(-100).byDefault();
        assertNotNull(rg);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildThrowsIllegalArgumentException1() {
        Range rg = Range.from(0).to(-100).by(1);
        assertNotNull(rg);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildThrowsIllegalArgumentException2() {
        Range rg = Range.from(0).to(100).by(-1);
        assertNotNull(rg);
    }

    @Test
    public void testIterator() {
        Range rg = get0to5();
        Iterator<Integer> itr = rg.iterator();
        assertNotNull(itr);
    }

    @Test
    public void testIteratorHasNext() {
        assertTrue(get0to5().iterator().hasNext());
    }

    @Test
    public void testIteratorNext() {
        Range rg = get0to5();
        Iterator<Integer> itr = rg.iterator();
        assertTrue(itr.hasNext());
        assertTrue(itr.next().intValue() == 0);
        assertTrue(itr.hasNext());
        assertTrue(itr.next().intValue() == 1);
        assertTrue(itr.hasNext());
        assertTrue(itr.next().intValue() == 2);
        assertTrue(itr.hasNext());
        assertTrue(itr.next().intValue() == 3);
        assertTrue(itr.hasNext());
        assertTrue(itr.next().intValue() == 4);
        assertTrue(itr.hasNext());
        assertTrue(itr.next().intValue() == 5);
        assertFalse(itr.hasNext());
    }

    @Test
    public void testUntil() {
        Range rg = Range.from(0).until(0).byDefault();
        assertFalse(rg.iterator().hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorThrowsNoSuchElementException() {
        Range rg = Range.from(0).until(0).byDefault();
        rg.iterator().next();
    }

    Range get0to5() {
        return Range.from(0).to(5).byDefault();
    }

    Range get0until5() {
        return Range.from(0).until(5).byDefault();
    }

    @Test
    public void testStream1() {
        Range rg = Range.from(1).to(100).byDefault();
        // rg.forEach(System.out::println);
        // rg.stream().map(i->i*2).forEach(System.out::println);
        System.out.println(rg.stream().reduce((a, b) -> a + b).get());
        Range.from(1).to(20).by(1).stream().map(this::fab).map(i -> i + " ").forEach(System.out::print);
    }

    @Test
    public void testCache() {
        assertNotNull(Range.getCache(100));
    }

    // @Test
    // public void testStream2(){
    // Range.from(1).to(Integer.MAX_VALUE).byDefault().stream().forEach(System.out::println);
    // }

    private int fab(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fab(n - 1) + fab(n - 2);
        }
    }

    @Test
    public void testPerformance1() {

        for (int i = 0; i < 1000000; i++) {
            for (int j = 0; j < 100; j++) {
                int k = j;
                k += 100;
            }
        }
    }

    @Test
    public void testPerformance2() {

        for (int i = 0; i < 1000000; i++) {
            Range.of(0, 100).forEach(k -> {
                k += 100;
            });
        }
    }
}
