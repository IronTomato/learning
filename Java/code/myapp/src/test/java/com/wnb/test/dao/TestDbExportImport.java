package com.wnb.test.dao;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.junit.Test;

public class TestDbExportImport {

    @Test
    public void test() throws Exception {
        DbExportImport.exportTables(JdbcUtil.getConnection(), new String[] { "city", "country", "countrylanguage" },
                new File("world.xml"));
    }
}
