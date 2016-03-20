package org.wnb.test.dao;

import static org.junit.Assert.*;

import java.util.ResourceBundle;

import org.junit.Test;

import com.mysql.jdbc.AssertionFailedException;

public class TestResourceBundle {

    @Test
    public void test() {
        ResourceBundle rs = ResourceBundle.getBundle("dbunit");
        String lang = rs.getString("language");
        assertEquals(lang, "zh");
        System.out.println(rs.getString("language"));
    }

}
