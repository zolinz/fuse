package zoli.backend;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.spi.DataFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZoliBack extends RouteBuilder {
	
	DataFormat jaxb = new JaxbDataFormat("myorder");

	private static String RESP = FileUtils.readFile("createDesignResponse_Success.xml");

	// too many comments not clean from 02 
	
	@Override
	public void configure() throws Exception {
		Logger myLog = LoggerFactory.getLogger(ZoliBack.class);
		/*from("activemq:queue:hfc.in")
		.log(LoggingLevel.INFO,  myLog, "Before marshalling ${headers} and body : ${body}")
		.unmarshal(jaxb)
		.to("myMsgProcessor")
		.marshal(jaxb)
		
		.log(LoggingLevel.INFO,  myLog, "After marshalling ${headers}  and body : ${body}");*/
	
		from("amq:queue:PLATFORM.PNI.CREATE_DESIGN_MNR.V1.REQ")
		//.delay(30000)
		.log(LoggingLevel.INFO,  myLog, "ZOLI GOT REQUEST ${headers} and body : ${body}")
		.log(LoggingLevel.INFO,  myLog, "ZOLI GOT REQUEST ${headers} and body : ${body}")
		.setBody(simple(RESP))
		.setHeader("JMSCorrelationID", simple("4eef4405-606e-46db-8c9c-af78e2811111"))
		.to("amq:queue:PLATFORM.PNI.CREATE_DESIGN_MNR.V1.RESP");
		
	}

}
