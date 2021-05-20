package com.ifood.challenge.location;

import org.springframework.stereotype.Service;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

=======
>>>>>>> 9106a3bd1c5de1db7445950847dc4fa76e0eb98f
@Service
public class LocationService {

    public List<Location> getLocation(int number) {

        ArrayList<Location> locations = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            locations.add(new Location(
                    "Location " + i,
                    new Random().nextDouble(),
                    new Random().nextDouble()
            ));
        }
        return locations;
    }
}

