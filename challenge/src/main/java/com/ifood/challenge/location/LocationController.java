package com.ifood.challenge.location;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Location> getLocations(@PathVariable("number")int number){

        if (number < 0) {
            throw new ExceptionController.BadArgumentsException("bad arguments");
        }

        return locationService.getLocation(number);
    }

}
