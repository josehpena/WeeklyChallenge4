package com.ifood.challenge.location;

import org.springframework.stereotype.Service;

@Service
public class LocationService {
    public Location[] getLocation(int number){
        Location locations[] = new Location[number];
        double doubleFirst = 1.000;
        double doubleSecond = 2.000;
        for(int i = 0; i < number; i++){
             locations[i] = new Location(
                    "Location "+i,
                     doubleFirst,
                     doubleSecond
             );
             doubleFirst += 0.001;
             doubleSecond += 0.001;
        }

        return locations;

    }

}
