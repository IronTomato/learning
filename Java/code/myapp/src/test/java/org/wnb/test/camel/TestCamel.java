package org.wnb.test.camel;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.junit.Test;

public class TestCamel {

	private final String userName = ActiveMQConnection.DEFAULT_USER;
	private final String password = ActiveMQConnection.DEFAULT_PASSWORD;
	private final String brokerUrl = ActiveMQConnection.DEFAULT_BROKER_URL;

	// @Test
	public void testProducer() throws Exception {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(userName, password, brokerUrl);

		CamelContext context = new DefaultCamelContext();
		context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		context.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				from("file:E:/Test").to("jms:queue:firstCamel");
			}
		});

		context.start();

		Thread.sleep(5000);
		context.stop();
	}

	private int i = 1;
	@Test
	public void testConsumer() throws Exception {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(userName, password, brokerUrl);

		CamelContext context = new DefaultCamelContext();
		context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		context.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				from("jms:queue:firstCamel").process(new Processor() {

					@Override
					public void process(Exchange exchange) throws Exception {
						System.out.println("====================================");
						System.out.println(String.format("this is the %sth", i++));
						InputStream body = exchange.getIn().getBody(InputStream.class);
						BufferedReader reader = new BufferedReader(new InputStreamReader(body));
						String firstLine = reader.readLine();
						reader.close();
						System.out.println(firstLine);
						System.out.println("====================================");
					}
				});
			}
		});

		context.start();

		Thread.sleep(5000);
		context.stop();
	}

}
