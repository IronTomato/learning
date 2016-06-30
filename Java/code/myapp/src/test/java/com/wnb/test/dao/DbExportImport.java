package com.wnb.test.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.xml.XmlDataSetWriter;
import org.junit.Test;

public class DbExportImport {

    public void exportDb() {
        Connection conn = JdbcUtil.getConnection();
        try {
            IDatabaseConnection databaseConnection = new DatabaseConnection(conn);
            QueryDataSet dataSet = new QueryDataSet(databaseConnection);
            dataSet.addTable("city");

            Writer writer = new FileWriter("city.xml");
            XmlDataSetWriter dataSetWriter = new XmlDataSetWriter(writer);
            dataSetWriter.write(dataSet);
            writer.flush();
            writer.close();

        } catch (DatabaseUnitException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void exportTables(Connection connection, String[] tableNames, File file) throws Exception {
        IDatabaseConnection databaseConnection = new DatabaseConnection(connection);
        QueryDataSet dataSet = new QueryDataSet(databaseConnection);
        for (String tableName : tableNames) {
            dataSet.addTable(tableName);
        }
        
        Writer writer = new FileWriter(file);
        XmlDataSetWriter dataSetWriter = new XmlDataSetWriter(writer);
        dataSetWriter.write(dataSet);
        writer.flush();
        writer.close();
        connection.close();

    }
}
