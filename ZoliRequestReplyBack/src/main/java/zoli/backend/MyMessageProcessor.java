package zoli.backend;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MyMessageProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		String payload = exchange.getIn().getBody(String.class);
		// do something with the payload and/or exchange here
		exchange.getIn().setBody("Changed body " + payload);
	}

}
