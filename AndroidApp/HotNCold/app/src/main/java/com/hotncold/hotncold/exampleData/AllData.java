package com.hotncold.hotncold.exampleData;

import com.hotncold.hotncold.dto.Location;

import java.util.List;

/**
 * Created by Klaxmax on 01.05.2017.
 */

public class AllData {

    public Location[] getLocations(){
        Location[] locations = new Location[3];
        locations[0] = new Location(true,"Hotspot 1","10",48.2167925, 16.340823400000067, "Dieser Hotspot ist voll super!","Alser Straße 1","http://Test.com");
        locations[1] = new Location(false,"Hotspot 2","20",48.2156925, 16.341823400000067,"Dieser Hotspot ist auch nicht schlecht!","Alser Straße 2","http://Test.com");
        locations[2] = new Location(true,"Hotspot 3","30",48.2177925, 16.342923400000067,"Dieser Hotspot ist nicht so gut!","Alser Straße 3","http://Test.com");
        return locations;
    }
}
