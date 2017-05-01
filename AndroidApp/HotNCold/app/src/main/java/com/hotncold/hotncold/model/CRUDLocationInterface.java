package com.hotncold.hotncold.model;

import com.hotncold.hotncold.dto.Location;

import java.util.List;

/**
 * Created by Klaxmax on 01.05.2017.
 */

public interface CRUDLocationInterface {

    public void create();
    public List<Location> getAll();
    public void update();
    public void delete();
}
