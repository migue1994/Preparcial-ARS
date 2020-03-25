package edu.eci.escualing.arsw.parcial.controller;

import edu.eci.escualing.arsw.parcial.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping(value = "/airports")
public class RestController {
    final AirportService airportService;

    public RestController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/{city}")
    public ResponseEntity<?> getAirportsByCity(@PathVariable String city) throws IOException {
        try {
            return new ResponseEntity<>(airportService.getAirportsByCity(city), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("No fue posible obtener los registros", HttpStatus.NOT_FOUND);
        }
    }

}
