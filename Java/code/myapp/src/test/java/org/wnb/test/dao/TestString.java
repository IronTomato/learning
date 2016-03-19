package org.wnb.test.dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestString {

    @Test
    public void test() {
        System.out.println(MethodName.add.toString());
    }

    private static String NAME_SPACE = "mybatis.xml.Mapper";

    private static enum MethodName {
        findById, findAll, add, update, delete;

        private String fullName;

        private MethodName() {
            fullName = TestString.NAME_SPACE + "." + this.name();
        }
        
        @Override
        public String toString(){
            return fullName;
        }

    }

}
