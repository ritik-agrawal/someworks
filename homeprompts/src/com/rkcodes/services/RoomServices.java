package com.rkcodes.services;

import com.rkcodes.elements.Room;
import javafx.util.Pair;

import java.util.List;
import java.util.Map;

public interface RoomServices {
    void addItem(Room room, Pair<String, Double> item);

    void setTotal(Room room);
}
