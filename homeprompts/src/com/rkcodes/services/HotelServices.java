package com.rkcodes.services;

import com.rkcodes.elements.Hotel;
import com.rkcodes.elements.Room;

import java.util.List;

public interface HotelServices {
    Hotel createHotel(String name);
    void addRoom(Hotel hotel, List<Room> rooms, Room room);
    void displayAllAvailableRooms(Hotel hotel);
    void displayAllInBudget(Hotel hotel, double budget);
}
