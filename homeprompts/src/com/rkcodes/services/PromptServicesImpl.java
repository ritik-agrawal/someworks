package com.rkcodes.services;

import com.rkcodes.elements.Hotel;
import com.rkcodes.elements.Room;
import javafx.util.Pair;

import java.util.List;
import java.util.Scanner;

public class PromptServicesImpl implements PromptServices {

    private static final String MENU = "1) Add Hotel.\n" +
            "2) Add Room.\n" +
            "3) Display all Available Rooms.\n" +
            "4) Display all rooms in budget.\n" +
            "I/p:";
    private static final String CREATE_HOTEL = "Creating a new Hotel.\n" +
            "Enter the name of Hotel:";
    private static final String HOTEL_CREATED = "Successfully created Hotel ";
    private static final String CREATE_ROOM = "Creating a Room.";
    private static final String ROOM_CREATED = "Successfully Room created.";
    private static final String ROOM_ITEM = "Item name:";
    private static final String ITEM_RATE = "Item Rate:";
    private static final String ADD_ITEM = "Add more Items?";
    private static final String CONTINUE_END = "Continue(0) or End (1)\n" + "I/p:";
    private static final String WRONG_INPUT = "Wrong Input.Please try again.";

    private Scanner input = new Scanner(System.in);

    private static HotelServices hotelServices = new HotelServicesImpl();
    private static RoomServices roomServices = new RoomServicesImpl();

    @Override
    public int displayMenu() {
        System.out.println("Prompt Services");
        displayDivider();
        System.out.println(MENU);
        int in = input.nextInt();
        return in;
    }

    @Override
    public void displayDivider() {
        System.out.println("-----------------------------------------------------");
    }

    @Override
    public void displayAllAvailRooms(Hotel hotel, double budget) {
        System.out.println("List of Rooms available in "+hotel.getName());
        displayDivider();
        List<Room> rooms = hotel.getRooms();
        int no = 1;
        for (Room room : rooms){
            displayRooms(room, budget, no);
            no++;
        }
        displayDivider();
    }

    @Override
    public void displayRooms(Room room, double budget, int no) {
        if (budget == 0){
            if (!room.isTaken()){
                System.out.println(no+")"+room.toString(no));
            }
        }else {
            double total = room.getTotal();
            if (!room.isTaken() && (total < budget || total == budget)){
                System.out.println(no+")"+room.toString(no));
            }
        }
    }

    @Override
    public Hotel displayCreateHotel() {
        System.out.println(CREATE_HOTEL);
        String textInput = input.next();
        Hotel hotel = hotelServices.createHotel(textInput);
        System.out.println(HOTEL_CREATED + hotel.getName());
        return hotel;
    }

    @Override
    public void displayCreateRoom(Hotel currentHotel) {
        int continueOrEnd = 0;
        System.out.println(CREATE_ROOM);
        Room room = new Room();
        while (continueOrEnd == 0){
            System.out.println(ROOM_ITEM);
            String textInput = input.next();
            System.out.println(ITEM_RATE);
            double rate = input.nextDouble();
            roomServices.addItem(room, new Pair<>(textInput, rate));
            System.out.println(ADD_ITEM);
            roomServices.setTotal(room);
            continueOrEnd = conitnueOrEnd();
        }
        hotelServices.addRoom(currentHotel, currentHotel.getRooms(), room);
        System.out.println(ROOM_CREATED);
    }

    @Override
    public int conitnueOrEnd() {
        int in= -1;
        Scanner ip = new Scanner(System.in);
        try {
            System.out.println(CONTINUE_END);
            in = ip.nextInt();
        } catch (Exception e) {
            System.out.println(WRONG_INPUT);
            return conitnueOrEnd();
        }
        return in;
    }
}
