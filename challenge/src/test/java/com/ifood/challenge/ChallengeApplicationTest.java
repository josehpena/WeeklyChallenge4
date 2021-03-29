package com.ifood.challenge;

import com.ifood.challenge.location.Location;
import com.ifood.challenge.location.LocationService;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChallengeApplicationTest extends LocationService {
    int passInt = 2;


    Location[] arrayForTest = new Location[passInt];


    @Test
    public void testResult(){
        arrayForTest[0] = new Location("Location 0", 1.0, 2.0);
        arrayForTest[1] = new Location("Location 1", 1.001, 2.001);
        Location[] locations = getLocation(passInt);

        assertArrayEquals(arrayForTest, locations);

}
}