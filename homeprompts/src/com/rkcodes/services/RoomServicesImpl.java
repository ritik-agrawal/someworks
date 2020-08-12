package com.rkcodes.services;

import com.rkcodes.elements.Room;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RoomServicesImpl implements RoomServices {

    @Override
    public void addItem(Room room, Pair<String, Double> item) {
        List<Pair<String, Double>> items;
        if (room.getItems() == null){
            items = new ArrayList<>();
            items.add(item);
            room.setItems(items);
        }else{
            items = room.getItems();
            items.add(item);
        }
    }

    @Override
    public void setTotal(Room room) {
        double total = 0;
        List<Pair<String, Double>> items;
        if (room.getItems() == null){
            items = new ArrayList<>();
        }else {
            items = room.getItems();
        }
        for (Pair<String, Double> item : items){
            total+=item.getValue();
        }
        room.setTotal(total);
    }
}
