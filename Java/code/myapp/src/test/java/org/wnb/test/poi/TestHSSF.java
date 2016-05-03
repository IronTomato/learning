package org.wnb.test.poi;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.wnb.test.poi.POIExcelHelper.Table;
import org.wnb.test.poi.POIExcelHelper.Table.TableRow;

public class TestHSSF {

//    @Test
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
    
    @Test
    public void testPOIHelper() throws IOException{
        String fileName = "F:/Test/myxls.xls";
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("mysheet");
        Table table = new Table(sheet, 1, 0);
        table.addColumn("id").addColumn("name").addColumn("sex").addColumn("age");
        TableRow row = table.creatRow();
        row.getCell("id").setCellValue(UUID.randomUUID().toString());
        row.getCell("name").setCellValue("wnb");
        row.getCell("sex").setCellValue("male");
        row.getCell("age").setCellValue(27);
        
        FileOutputStream fos = new FileOutputStream(fileName);
        wb.write(fos);
        fos.close();
    }

}
