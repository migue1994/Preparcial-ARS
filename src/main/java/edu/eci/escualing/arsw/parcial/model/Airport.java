package edu.eci.escualing.arsw.parcial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Airport {
    private String airportId;
    private String code;
    private String name;
    private Location location;
    private String city;
    private String cityId;
    private String countryCode;
}
