Spring Boot Example
===================

The objective of the project is to consume jms messages and push them to elastic 6.1 using highEndRestClient. Edit Application.properties file to change the AMQ
configuration. For now, the queue name is defined in ElasticLogAmqAutowiredRoute class

You will need to compile this example first:
  mvn install

To run the example type
  mvn spring-boot:run

You can also execute the JAR directly:

  java -jar target/camel-amq-elastic-log-0.0.1-SNAPSHOT.jar

You will see the message printed to the console every second.

To stop the example hit ctrl + c

