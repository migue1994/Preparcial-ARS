package edu.eci.escualing.arsw.parcial.service.impl;

import edu.eci.escualing.arsw.parcial.cache.CacheService;
import edu.eci.escualing.arsw.parcial.model.Airport;
import edu.eci.escualing.arsw.parcial.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

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
