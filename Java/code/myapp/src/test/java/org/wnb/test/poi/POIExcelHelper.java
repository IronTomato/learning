package org.wnb.test.poi;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class POIExcelHelper {

    public static class SheetHelper {
        private Sheet sheet;

        private SheetHelper(Sheet sheet) {
            this.sheet = sheet;
        }

        public static SheetHelper wrap(Sheet sheet) {
            return new SheetHelper(sheet);
        }

        public Sheet getOrginal() {
            return sheet;
        }

        public Row getRow(int rowIndex) {
            Row row = sheet.getRow(rowIndex);
            if (row == null) {
                row = sheet.createRow(rowIndex);
            }
            return row;
        }
    }

    public static class Table {
        private SheetHelper sheet;
        private int positionRowIndex;
        private int positionColumnIndex;
        private int rowCount = 0;
        private int columnCount = 0;

        private Map<String, Integer> columnNameMap = new HashMap<>();

        public Table(Sheet sheet, int rowIndex, int columnIndex) {
            this.sheet = SheetHelper.wrap(sheet);
            this.positionRowIndex = rowIndex;
            this.positionColumnIndex = columnIndex;
        }

        public Table addColumn(String columnName) {
            if (columnNameMap.containsKey(columnName))
                throw new RuntimeException("Dunplicate column name.");
            int columnIndex = positionColumnIndex + columnCount;
            sheet.getRow(positionRowIndex).createCell(columnIndex).setCellValue(columnName);
            columnNameMap.put(columnName, columnIndex);
            columnCount++;
            return this;
        }
        
        public static class TableRow{
            private Table table;
            private TableRow(Table table){
                this.table = table;
            }
        }
    }
}
