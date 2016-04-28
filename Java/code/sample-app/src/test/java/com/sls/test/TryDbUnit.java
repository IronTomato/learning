package com.sls.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.CachedDataSet;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.stream.IDataSetProducer;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlProducer;
import org.dbunit.dataset.xml.XmlDataSet;
import org.dbunit.dataset.xml.XmlProducer;
import org.dbunit.operation.DatabaseOperation;
import org.dbunit.util.FileHelper;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TryDbUnit extends AbstractJUnit4SpringContextTests {

	@Autowired
	DataSource dataSource;
	
	@Rule
	public TestRule printTraceRule = new PrintTraceRule();

	@Test
	public void test() throws Exception {
//		File file = new File("E:/Test/city-xmlwriter.xml");
		File file = new File("E:/Test/city.xml");
//		exportData(file);
		importData(file);
	}

	private IDatabaseConnection getConnection() throws DatabaseUnitException, SQLException {
		return new DatabaseConnection(dataSource.getConnection());
	}
	
	private void exportData(File file) throws DatabaseUnitException, SQLException, FileNotFoundException, IOException{
		QueryDataSet dataSet = new QueryDataSet(getConnection());
		dataSet.addTable("city", "select * from city");
//		dataSet.addTable("t_user_info","select * from t_user_info");

		FlatXmlDataSet.write(dataSet,new FileWriter(file),"UTF-8");
	}
	
	private void importData(File file) throws MalformedURLException, DatabaseUnitException, SQLException{
		IDataSetProducer dataSetProducer = new 	FlatXmlProducer(FileHelper.createInputSource(file));
		IDataSet dataSet = new CachedDataSet(dataSetProducer);
		DatabaseOperation operation = DatabaseOperation.CLEAN_INSERT;
		DatabaseOperation.TRANSACTION(operation);
		operation.execute(getConnection(), dataSet);
		DatabaseOperation.CLOSE_CONNECTION(operation);
				
	}

}
