package zoli.backend;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import myorder.Shiporder;

public class MyMessageProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Shiporder payload = exchange.getIn().getBody(myorder.Shiporder.class);
		// do something with the payload and/or exchange here
		String orderPerson ="Changed body " + payload.getOrderperson();
		
		payload.setOrderperson(orderPerson);
	}

}
