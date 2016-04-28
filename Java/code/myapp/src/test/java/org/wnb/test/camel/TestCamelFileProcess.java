package org.wnb.test.camel;

import static org.junit.Assert.*;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.junit.Test;

public class TestCamelFileProcess {

	@Test
	public void test() throws Exception {
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				from("file:E:/Camel/inbox/?delay=3000").process(new Processor() {

					@Override
					public void process(Exchange exchange) throws Exception {
						System.out.println(exchange.getIn().getHeader(Exchange.FILE_NAME));
					}
				}).to("file:E:/Camel/outbox");
			}
		});
		
		boolean loop = true;
		context.start();
		while(loop){
			Thread.sleep(2500);
		}
		context.stop();
	}

}
