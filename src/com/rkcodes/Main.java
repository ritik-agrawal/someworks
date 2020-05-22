package com.rkcodes;

import com.rkcodes.elements.Hotel;
import com.rkcodes.elements.Room;
import com.rkcodes.services.*;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static HotelServices hs = new HotelServicesImpl();
    private static PromptServices ps = new PromptServicesImpl();
    private static RoomServices rs = new RoomServicesImpl();

    private static List<Hotel> hotels = new ArrayList<>();

    public static void main(String[] args)  {
	   int continueOrEnd = 0 ;
	   int in;
	   double rate = 0;
	   String textInput;
	   Hotel currentHotel = null;
	   Scanner input = new Scanner(System.in);
	   while (continueOrEnd == 0){
           ps.displayMenu();
           in = input.nextInt();
           switch (in){
               case 1:
                   ps.displayCreateHotel();
                   textInput = input.next();
                   Hotel hotel = hs.createHotel(textInput);
                   hotels.add(hotel);
                   currentHotel = hotel;
                   ps.successCreated(hotel,null);
                   break;

               case 2:
                   boolean addItem = true;
                   System.out.println("Creating Room.");
                   Room room = new Room();
                   List<Room> rooms = currentHotel.getRooms();
                   while (addItem){
                       System.out.println("Item Name:");
                       textInput = input.next();
                       System.out.println("Item Rate:");
                       rate = input.nextDouble();
                       rs.addItem(room, new Pair<>(textInput, rate));
                       System.out.println("Add more items?");
                       ps.conitnueOrEnd();
                       in = input.nextInt();
                       if (in == 1){
                           addItem = false;
                       }
                   }
                   rs.setTotal(room);
                   hs.addRoom(currentHotel,rooms,room);
                   System.out.println("Room successfully created.");
                   break;

               case 3:
                   ps.displayAllAvailRooms(currentHotel);
                   break;

               case 4:
                   System.out.println("Enter your budget: Rs");
                   double budget = input.nextDouble();
                   ps.displayAllInBudgetRooms(currentHotel, budget);
                   break;

               default:
                   System.out.println("Wrong Input: "+ in);
           }
           ps.conitnueOrEnd();
           continueOrEnd = input.nextInt();
       }
    }
}
