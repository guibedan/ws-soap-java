package com.guibedan.ws.soap.config;

import com.guibedan.ws.soap.ws.endpoint.ClienteEndpoint;
import jakarta.xml.ws.Endpoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SoapConfig {

    @Value("${ws.port}")
    private String port;

    @Value("${ws.host}")
    private String host;

    @Value("${ws.path}")
    private String path;

    @Bean
    public Endpoint clienteSoapPublisher(ClienteEndpoint endpoint) {
        Endpoint.publish(host + port + path, endpoint);
        return null;
    }

}
