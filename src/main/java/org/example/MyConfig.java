package org.example;

import org.example.web.CompteRestJaxRSAPI;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    public ResourceConfig resourceConfig(){
        ResourceConfig jerseyservlet = new ResourceConfig();
        jerseyservlet.register(CompteRestJaxRSAPI.class);
        return jerseyservlet;
    }
}
