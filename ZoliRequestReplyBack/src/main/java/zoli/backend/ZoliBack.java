package zoli.backend;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.spi.DataFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZoliBack extends RouteBuilder {
	
	DataFormat jaxb = new JaxbDataFormat("myorder");

	//another commit from04
	// new comment from 04
	// comment from branch 2
	//latest comment from branch4 to merge remotely
	// this is a new comment from branch 2
	// testing github with more comments
	@Override
	public void configure() throws Exception {
		Logger myLog = LoggerFactory.getLogger(ZoliBack.class);
		from("activemq:queue:hfc.in")
		.log(LoggingLevel.INFO,  myLog, "Before marshalling ${headers} and body : ${body}")
		.unmarshal(jaxb)
		.to("myMsgProcessor")
		.marshal(jaxb)
		
		.log(LoggingLevel.INFO,  myLog, "After marshalling ${headers}  and body : ${body}");
	
	}

}
