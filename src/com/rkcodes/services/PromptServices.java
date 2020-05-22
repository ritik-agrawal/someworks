package com.rkcodes.services;

import com.rkcodes.elements.Hotel;
import com.rkcodes.elements.Room;

public interface PromptServices {
    void displayMenu();

    void displayDivider();

    void displayAllAvailRooms(Hotel hotel);

    void displayAllInBudgetRooms(Hotel hotel, double budget);

    void displayCreateHotel();

    void successCreated(Hotel hotel, Room room);

    void conitnueOrEnd();
}
