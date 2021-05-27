package com.ifood.challenge.location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "feather/")
public class LocationController {
    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping(path="/{number}")
    public ResponseEntity<List<Location>> getLocations(@PathVariable("number")int number){
        List<Location> listLocation = null;
        try {
             listLocation = locationService.getLocation(number);
            return new ResponseEntity<List<Location>>(listLocation, HttpStatus.OK);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return new ResponseEntity<List<Location>>(listLocation, HttpStatus.BAD_REQUEST);
        }

    }

}
