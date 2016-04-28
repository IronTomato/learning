package org.wnb.test;

import static org.junit.Assert.*;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class Dom4jTest {

    @Test
    public void test() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document doc = reader.read(this.getClass().getClassLoader().getResourceAsStream("applicationContext.xml"));
        Element root = doc.getRootElement();
        Element  e = (Element)root.elements().get(0);
        System.out.println(root.element("component-scan").attribute("base-package").getValue());
    }

}
