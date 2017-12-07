package br.com.cinq.spring.data.sample.application.controller;

import br.com.cinq.spring.data.sample.application.entity.City;
import br.com.cinq.spring.data.sample.application.service.CityService;
import br.com.cinq.spring.data.sample.application.service.ServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Controller
@Path("/cities")
public class CityController {

    private final ServiceFacade serviceFacade;

    @Autowired
    public CityController(ServiceFacade serviceFacade) {
        this.serviceFacade = serviceFacade;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getCitiesByCountry(@QueryParam("country") String countryName){
        List<City> result = serviceFacade.getCityService().getCitiesByCountry(countryName);

        return Response.status(200).entity(result).build();
    }
}
