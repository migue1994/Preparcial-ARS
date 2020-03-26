package edu.eci.escualing.arsw.parcial.service.impl;

import java.io.IOException;

import org.springframework.stereotype.Service;

import edu.eci.escualing.arsw.parcial.cache.CacheService;
import edu.eci.escualing.arsw.parcial.model.Airport;
import edu.eci.escualing.arsw.parcial.service.AirportService;

@Service
public class AirportServiceImpl implements AirportService {

    private final CacheService cacheService;

    public AirportServiceImpl(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @Override
    public Airport[] getAirportsByCity(String city) throws IOException {
        return cacheService.getAirportsByCity(city);
    }
}
