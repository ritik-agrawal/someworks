package com.rkcodes.services;

import com.rkcodes.elements.Hotel;
import com.rkcodes.elements.Room;

import java.util.List;

public class PromptServicesImpl implements PromptServices {
    @Override
    public void displayMenu() {
        System.out.println("Prompt Services");
        displayDivider();
        System.out.println("1) Add Hotel.\n" +
                           "2) Add Room.\n" +
                           "3) Display all available rooms.\n" +
                           "4) Display rooms in budget.\n" +
                "Enter the no co-responding to the command.\n" +
                "I/p:");
    }

    @Override
    public void displayDivider() {
        System.out.println("-----------------------------------------------------");
    }

    @Override
    public void displayAllAvailRooms(Hotel hotel) {
        System.out.println("List of Rooms available in "+hotel.getName());
        displayDivider();
        List<Room> rooms = hotel.getRooms();
        int no = 1;
        for (Room room : rooms){
            if (!room.isTaken()) {
                System.out.println(no+")"+room.toString(no));
            }
            no++;
        }
        displayDivider();
    }

    @Override
    public void displayAllInBudgetRooms(Hotel hotel, double budget) {
        if (hotel.getRooms() == null){
            System.out.println("No rooms created. Create room in hotel "+hotel.getName());
        }
        System.out.println("List of Rooms available in "+hotel.getName());
        displayDivider();
        List<Room> rooms = hotel.getRooms();
        int no = 1;
        for (Room room : rooms){
            double total = room.getTotal();
            if (!room.isTaken() && (total<budget || total == budget) ) {
                System.out.println(no+")"+room.toString(no));
            }
            no++;
        }
        displayDivider();
    }

    @Override
    public void displayCreateHotel() {
        System.out.println("Creating a new hotel.\n" +
                           "Name of the Hotel:");
    }

    @Override
    public void successCreated(Hotel hotel, Room room) {
        if (hotel == null){
            System.out.println("Successfully created room.");
        }else {
            System.out.println("Successfully created hotel "+hotel.getName());
        }
    }

    @Override
    public void conitnueOrEnd() {
        System.out.println("Continue(0) or End (1)\n" +
                           "I/p:");
    }
}
