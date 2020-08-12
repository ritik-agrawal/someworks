package com.rkcodes.services;

import com.rkcodes.elements.Hotel;
import com.rkcodes.elements.Room;

public interface PromptServices {
    int displayMenu();

    void displayDivider();

    Hotel displayCreateHotel();

    void displayCreateRoom(Hotel currentHotel);

    void displayAllAvailRooms(Hotel hotel, double budget);

    void displayRooms(Room room, double budget, int no);

    int conitnueOrEnd();
}
