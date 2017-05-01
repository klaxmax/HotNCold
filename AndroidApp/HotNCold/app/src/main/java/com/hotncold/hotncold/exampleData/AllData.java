package com.hotncold.hotncold.exampleData;

import com.hotncold.hotncold.dto.Location;

import java.util.List;

/**
 * Created by Klaxmax on 01.05.2017.
 */

public class AllData {

    public Location[] getLocations(){
        Location[] locations = new Location[1];
        locations[0] = new Location("false","Test 1","10");
        return locations;
    }
}
