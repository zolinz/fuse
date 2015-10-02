package zoli.backend;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZoliBack extends RouteBuilder {
	
	

	// comment from branch 2
	// this is a new comment from branch 2
	// testing github with more comments
	@Override
	public void configure() throws Exception {
		Logger myLog = LoggerFactory.getLogger(ZoliBack.class);
		from("activemq:queue:hfc.in").to("myMsgProcessor")
		//.log(LoggingLevel.INFO,  myLog, "EXCHNAGEPATTERN  BackendRoute ${exchangePattern}")
		.log(LoggingLevel.INFO,  myLog, "BackendRoute ${in.headers}");
	
	}

}
