package com.hotncold.hotncold.model;

import com.hotncold.hotncold.dto.Location;
import com.hotncold.hotncold.exampleData.AllData;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Klaxmax on 01.05.2017.
 */

public class LocationsModel implements CRUDLocationInterface {
    private List<Location> locations;


    @Override
    public void create() {

    }

    @Override
    public List<Location> getAll() {
        AllData ad = new AllData();
        locations = Arrays.asList(ad.getLocations());
        return locations;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
