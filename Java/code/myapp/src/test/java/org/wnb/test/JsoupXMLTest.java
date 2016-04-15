package org.wnb.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

public class JsoupXMLTest {

    @Test
    public void test() throws IOException {
        Document doc = Jsoup.parse(this.getClass().getClassLoader().getResourceAsStream("applicationContext.xml"), "UTF-8", "");
        System.out.println( doc.select("context:component-scan").attr("base-package"));
    }

}
