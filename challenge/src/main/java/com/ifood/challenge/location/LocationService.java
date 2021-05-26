package com.ifood.challenge.location;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class LocationService {

    public List<Location> getLocation(int number) {

        if(number < 0){
            throw new IllegalArgumentException();
        }

        ArrayList<Location> locations = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            locations.add(new Location(
                    "Location " + (i + 1),
                    new Random().nextDouble(),
                    new Random().nextDouble()
            ));
        }
        return locations;
    }
}

