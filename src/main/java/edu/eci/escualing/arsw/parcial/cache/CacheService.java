package edu.eci.escualing.arsw.parcial.cache;

import edu.eci.escualing.arsw.parcial.model.Airport;

import java.io.IOException;

public interface CacheService {

    Airport[] getAirportsByCity(String city) throws IOException;

}
