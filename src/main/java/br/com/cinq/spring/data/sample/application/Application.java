package br.com.cinq.spring.data.sample.application;

import br.com.cinq.spring.data.sample.application.service.ServiceFacade;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        ServiceFacade serviceFacade = context.getBean(ServiceFacade.class);
        serviceFacade.loadData();
    }
}
