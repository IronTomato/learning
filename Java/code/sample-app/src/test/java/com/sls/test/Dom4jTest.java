package com.sls.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class Dom4jTest {

	private File file = new File("E:/Work/mall-physical-model.xml");
	private File outFile = new File("E:/Work/mall-physical-model-modified.xml");

	@Test
	public void test() throws DocumentException, IOException {
		SAXReader reader = new SAXReader();
		Document doc = reader.read(file);
		Element root = doc.getRootElement();
		List<String> routing = Arrays.asList(new String[] { "RootObject", "Children", "Model", "Tables" });
		Element tablesElement = getByRouting(root, routing);
		List<Element> tables = tablesElement.elements("Table");
		for (Element table : tables) {
			List<Element> columns = table.element("Columns").elements("Column");
			for (Element column : columns) {
				Element comment = column.element("Comment");
				Element name = column.element("Name");
				if (comment != null) {
					System.out.println(comment.getText());
					name.setText(comment.getText());
				}
			}
		}
		
		XMLWriter writer = new XMLWriter(new FileWriter(outFile));
		writer.write(doc);
		writer.flush();
		writer.close();
		
		// System.out.println(tablesElement.getName());
	}

	private Element getByRouting(Element root, List<String> routing) {
		for (String name : routing) {
			root = root.element(name);
		}
		return root;
	}

}
