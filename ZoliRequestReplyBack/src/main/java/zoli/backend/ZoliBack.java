package zoli.backend;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.spi.DataFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZoliBack extends RouteBuilder {
	
	DataFormat jaxb = new JaxbDataFormat("myorder");

	// comment from branch 2
	// this is a new comment from branch 2
	// testing github with more comments
	@Override
	public void configure() throws Exception {
		Logger myLog = LoggerFactory.getLogger(ZoliBack.class);
		from("activemq:queue:hfc.in")
		.unmarshal(jaxb)
		.to("myMsgProcessor")
		//.log(LoggingLevel.INFO,  myLog, "EXCHNAGEPATTERN  BackendRoute ${exchangePattern}")
		.log(LoggingLevel.INFO,  myLog, "BackendRoute ${in.headers}");
	
	}

}
