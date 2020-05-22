package com.rkcodes.services;

import com.rkcodes.elements.Hotel;
import com.rkcodes.elements.Room;

import java.util.ArrayList;
import java.util.List;

public class HotelServicesImpl implements HotelServices {
    @Override
    public Hotel createHotel(String name) {
        return new Hotel(name);
    }

    @Override
    public void addRoom(Hotel hotel, List<Room> rooms, Room room) {
        if (null != rooms) {
            rooms.add(room);
        } else {
            rooms = new ArrayList<>();
            rooms.add(room);
        }
        hotel.setRooms(rooms);
    }

    @Override
    public void displayAllAvailableRooms(Hotel hotel) {

    }

    @Override
    public void displayAllInBudget(Hotel hotel, double budget) {

    }
}
