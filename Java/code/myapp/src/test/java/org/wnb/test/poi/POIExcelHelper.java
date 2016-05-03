package org.wnb.test.poi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.apache.poi.ss.usermodel.Cell;
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

    public static class Table implements Iterable<Table.TableRow> {
        private SheetHelper sheet;
        private int positionRowIndex;
        private int positionColumnIndex;
        private int rowCount = 0;
        private int columnCount = 0;
        private List<Table.TableRow> tableRows = new ArrayList<>();

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

        public TableRow creatRow() {
            Row row = sheet.getRow(positionRowIndex + rowCount + 1);
            rowCount++;
            TableRow tableRow = this.new TableRow(row);
            tableRows.add(tableRow);

            return tableRow;
        }

        @Override
        public Iterator<TableRow> iterator() {
            return tableRows.iterator();
        }

        public class TableRow {
            private Row row;

            private TableRow( Row row) {
                this.row = row;
            }

            public Cell getCell(String columnName) {
                if (!Table.this.columnNameMap.containsKey(columnName))
                    throw new NoSuchElementException("Column name [" + columnName + "] not exist.");

                int columnIndex = Table.this.columnNameMap.get(columnName).intValue();
                Cell cell = row.getCell(columnIndex);
                if (cell == null) {
                    cell = row.createCell(columnIndex);
                }
                return cell;
            }
        }
        
        private class Merger{
            private String mergeColumnName;
            private Merger(String mergeColumnName){
                this.mergeColumnName = mergeColumnName;
            }
            
            public void on(String conditionColumnName){
                
                for(TableRow row:Table.this){
                    
                }
            }
        }
    }
}
