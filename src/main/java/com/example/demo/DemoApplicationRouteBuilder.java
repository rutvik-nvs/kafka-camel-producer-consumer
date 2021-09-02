package com.example.demo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class DemoApplicationRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        // Kafka Route for creating messages and pushing into the topic
        from("timer:mockData")
            .transform(simple("Testing..."))
            .to("kafka:my-topic?brokers=172.30.200.84:9092")
            .to("log:Producer");

        from("kafka:my-topic?brokers=172.30.200.84:9092")
            .to("log:Consumer");
    }
}