package nl.cimt.elastic_log;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.properties.PropertiesComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class SampleAutowiredAmqRoute extends RouteBuilder{
	private static String amq_name = "queue.elasticsearch.logging"; 
	 @Override
	    public void configure() throws Exception {
	        from("amq:"+amq_name)
	            .to("log:sample")
	        .bean(ElasticBean.class);
	    }
}
