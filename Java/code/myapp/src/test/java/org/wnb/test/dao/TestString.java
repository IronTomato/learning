package org.wnb.test.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.junit.Test;

public class TestString {

    // @Test
    public void test() {
        System.out.println(MethodName.add.toString());
    }

    // @Test
    public void testIntger() {
        int n = 0;
        int m = 0;
        for (int i = 0; i < 100000; i++) {
            String s = Integer.toString(Math.abs(UUID.randomUUID().hashCode()), 36);
            if (s.length() > 6) {
                System.out.println(s);
                n++;
            }
            if (s.length() < 6) {
                System.out.println(s);
                m++;
            }
        }
        System.out.println(n);
        System.out.println(m);
    }

    // @Test
    public void testRecommendCode() {
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < 1000000; i++) {
            String code = randomCode3();
            set.add(code);
            // System.out.println(code);
        }
        System.out.println(set.size());
        // System.out.println(Integer.toString(35, 36));
        // System.out.println(randomCode3());
    }

    // @Test
    public void testLong() {
        System.out.println(Long.toString(Math.abs(new Random().nextLong()), 36));
    }

    @Test
    public void tttt() {
        for (int i = 0; i < 220; i++) {
            int t = ((int) (i / 6.6) + (int) (i / 9.9)) * 10 + i;
            System.out.println(i + "," + t);
//            if (t <= 220) {
//                System.out.println(t);
//                break;
//            }
        }
        // System.out.println((int)(10/6.6));
    }

    private String randomCode1() {
        String source = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random ran = new Random();
        char[] re = new char[6];
        for (int i = 0; i < 6; i++) {
            re[i] = source.charAt(ran.nextInt(source.length()));
        }
        return new String(re);
    }

    private String randomCode2() {
        return Integer.toString(Math.abs(UUID.randomUUID().toString().hashCode()), 36);
    }

    private String randomCode3() {
        return Integer.toString(new Random().nextInt(1785743751) + 52521875, 36).toUpperCase();
    }

    private static String NAME_SPACE = "mybatis.xml.Mapper";

    private static enum MethodName {
        findById, findAll, add, update, delete;

        private String fullName;

        private MethodName() {
            fullName = TestString.NAME_SPACE + "." + this.name();
        }

        @Override
        public String toString() {
            return fullName;
        }

    }

}
