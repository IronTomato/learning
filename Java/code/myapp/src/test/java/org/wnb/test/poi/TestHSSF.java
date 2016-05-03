package org.wnb.test.poi;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

public class TestHSSF {

    @Test
    public void test() throws IOException {
        String fileName = "F:/Test/myxls.xls";
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("mysheet");
        HSSFRow row = sheet.createRow(3);
        assertNotNull(row.getCell(1));
        row.createCell(4).setCellValue("test");
        FileOutputStream fos = new FileOutputStream(fileName);
        wb.write(fos);
        fos.close();
    }

}
