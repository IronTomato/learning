package com.sls.test.dbunit;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.dbunit.Assertion;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DefaultDataSet;
import org.dbunit.dataset.DefaultTable;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@TransactionConfiguration(defaultRollback = true)
public class BaseDaoTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private DataSource dataSource;

	private IDatabaseConnection connection;

	@Before
	public void initDbunit() throws Exception {
		connection = new DatabaseConnection(DataSourceUtils.getConnection(dataSource));
	}

	protected void setupDataSet(String classpathFile) throws Exception {
		IDataSet dataSet = new FlatXmlDataSetBuilder().build(new ClassPathResource(classpathFile).getFile());
		DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
	}

	protected void clearTable(String tableName) throws Exception {
		DefaultDataSet dataSet = new DefaultDataSet();
		dataSet.addTable(new DefaultTable(tableName));
		DatabaseOperation.DELETE_ALL.execute(connection, dataSet);
	}

	protected void verifyDataSet(String classpathFile) throws Exception {
		IDataSet expected = new FlatXmlDataSetBuilder().build(new ClassPathResource(classpathFile).getFile());
		IDataSet actual = connection.createDataSet();
		for (String tableName : expected.getTableNames()) {
			Assertion.assertEquals(expected.getTable(tableName), actual.getTable(tableName));
		}
	}

	protected void verifyTable(String classpathFile, String tableName) throws Exception {
		IDataSet expected = new FlatXmlDataSetBuilder().build(new ClassPathResource(classpathFile).getFile());
		IDataSet actual = connection.createDataSet();
		Assertion.assertEquals(expected.getTable(tableName), actual.getTable(tableName));
	}

	protected void verifyEmpty(String tableName) throws Exception {
		IDataSet actual = connection.createDataSet();
		assertEquals(0, actual.getTable(tableName).getRowCount());
	}
}
