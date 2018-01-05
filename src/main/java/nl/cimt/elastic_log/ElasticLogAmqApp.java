package nl.cimt.elastic_log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//CHECKSTYLE:OFF
@SpringBootApplication
@EnableAutoConfiguration
@ImportResource({"/META-INF/spring/amq.xml"})
public class ElasticLogAmqApp {
	
    public static void main(String[] args) {
    	SpringApplication app = new SpringApplication(ElasticLogAmqApp.class);
        app.run();
    	
    }

	
}
