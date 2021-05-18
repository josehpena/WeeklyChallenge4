package com.ifood.challenge.location;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class LocationService {
    public List<Location> getLocation(int number) {

        Location locations[] = new Location[number];
        for (int i = 0; i < number; i++) {
            locations[i] = new Location(
                    "Location " + i,
                    new Random().nextDouble(),
                    new Random().nextDouble()
            );
        }
        return List.of(
                locations);
    }
}

