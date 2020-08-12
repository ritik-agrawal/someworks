package com.rkcodes;

import com.rkcodes.elements.Hotel;
import com.rkcodes.services.*;

import java.util.ArrayList;
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
	   Hotel currentHotel = null;
	   Scanner input = new Scanner(System.in);
	   while (continueOrEnd == 0){
           in = ps.displayMenu();
           switch (in){
               case 1:
                   Hotel hotel = ps.displayCreateHotel();
                   hotels.add(hotel);
                   currentHotel = hotel;
                   break;

               case 2:
                   ps.displayCreateRoom(currentHotel);
                   break;

               case 3:
                   ps.displayAllAvailRooms(currentHotel,0);
                   break;

               case 4:
                   System.out.println("Enter your budget: Rs");
                   double budget = input.nextDouble();
                   ps.displayAllAvailRooms(currentHotel, budget);
                   break;

               default:
                   System.out.println("Wrong Input: "+ in);
           }
           continueOrEnd = ps.conitnueOrEnd();
       }
    }
}
