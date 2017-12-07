package br.com.cinq.spring.data.sample.application;

import br.com.cinq.spring.data.sample.application.controller.CityController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("rest")
public class Config extends ResourceConfig {

    public Config() {
        register(CityController.class);
    }
}
