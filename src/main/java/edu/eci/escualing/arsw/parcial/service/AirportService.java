package edu.eci.escualing.arsw.parcial.service;

import edu.eci.escualing.arsw.parcial.model.Airport;

import java.io.IOException;

public interface AirportService {
    Airport[] getAirportsByCity(String city) throws IOException;
}
