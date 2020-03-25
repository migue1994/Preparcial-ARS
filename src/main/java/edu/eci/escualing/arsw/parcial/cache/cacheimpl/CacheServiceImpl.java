package edu.eci.escualing.arsw.parcial.cache.cacheimpl;

import com.google.gson.Gson;
import edu.eci.escualing.arsw.parcial.cache.CacheService;
import edu.eci.escualing.arsw.parcial.connection.HttpConnection;
import edu.eci.escualing.arsw.parcial.model.Airport;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CacheServiceImpl implements CacheService {

    private final HttpConnection httpConnection;

    ConcurrentHashMap<String, Long> times = new ConcurrentHashMap<>();
    ConcurrentHashMap<String, Airport[]> airportRepository = new ConcurrentHashMap<>();

    public CacheServiceImpl(HttpConnection httpConnection) {
        this.httpConnection = httpConnection;
    }

    @Override
    public Airport[] getAirportsByCity(String city) throws IOException {

        long minutes = 5;
        long timeCache = minutes * 1000000000;

        long currentTime = System.nanoTime();

        if (times.contains(city)) {
            if (currentTime - times.get(city) > timeCache) {
                long newTime = System.nanoTime();
                Airport[] airports = getAirportsFromApi(city);
                airportRepository.replace(city, airports);
                times.replace(city, newTime);
                return airports;
            }else {
                return airportRepository.get(city);
            }
        }else {
            long newTime = System.nanoTime();
            Airport[] airports = getAirportsFromApi(city);
            airportRepository.put(city, airports);
            times.put(city, newTime);
            return airports;
        }
    }

    private Airport[] getAirportsFromApi(String city) throws IOException {
        String data = httpConnection.getConnection(city);
        return new Gson().fromJson(data, Airport[].class);
    }
}
