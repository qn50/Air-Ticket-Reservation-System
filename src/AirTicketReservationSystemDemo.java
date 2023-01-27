
/*
 * Name: Ahmed Abdullah Qahtan
 * ID: 2046143
 * Course Number: CPCS203
 * Section: H
 * Date: 2021/3/21
 * Emile: AAHMEDQAHTAN0001@stu.kau.edu.sa  ,   Qahtanqq99@icloud.com
 */
import java.io.*;
import java.util.*;

public class AirTicketReservationSystemDemo {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        Airline [] array = new Airline[10];
        File InputDB = new File("inputDB.txt");
        File InputBookings = new File("inputBookings.txt");
        
        File PrintBookings = new File("printBookings.txt");
        File PrintLog = new File("printLog.txt");
        
        if (!InputDB.exists() && !InputBookings.exists()) {
            System.out.println(InputDB + " or " + InputBookings + " doesn't exist");
            System.exit(0);
        }
        Scanner inDB = new Scanner(InputDB);
        Scanner inB = new Scanner(InputBookings);
        PrintWriter outB = new PrintWriter(PrintBookings);
        PrintWriter outlog = new PrintWriter(PrintLog);
        
        Airline[] airlainArray = new Airline[inDB.nextInt()];
        Airport[] airportArray = new Airport[inDB.nextInt()];
        Flight[] flightArray = new Flight[inDB.nextInt()];
        
        int airlainArrayIndex = 0;
        int airportArrayIndex = 0;
        int flightArrayIndex = 0;
        
        outlog.println("");
        outlog.println("--------------- Air Ticket Reservation System Log ---------------\n\n");
        String command = inDB.next();
        do {
            
            if (command.equalsIgnoreCase("ADD_Airline")) {
                ADD_Airline(airlainArray, inDB, outlog, airlainArrayIndex);
                airlainArrayIndex++;
            } else if (command.equalsIgnoreCase("ADD_Airport")) {
                ADD_Airport(airportArray, inDB, outlog, airportArrayIndex);
                airportArrayIndex++;
            } else if (command.equalsIgnoreCase("ADD_Flight")) {
                ADD_Flight(flightArray, inDB, outlog, flightArrayIndex);
                flightArrayIndex++;
            }
            
            command = inDB.next();
        } while (!command.equalsIgnoreCase("Quit"));
        
        printLog(airlainArray, flightArray, airportArray, outlog);
//****************************************************************************** part 2

        Booking[] bookingArray = new Booking[inB.nextInt()];
        int bookingArrayIndex = 0;
        
        String command2 = inB.next();
        do {
            if (command2.equalsIgnoreCase("NewBooking")) {
                ADD_Booking(bookingArray, airlainArray, airportArray, flightArray, inB, bookingArrayIndex);
                bookingArrayIndex++;
            }
            command2 = inB.next();
        } while (!command2.equalsIgnoreCase("Quit"));
        outB.print("\n--------------- Welcome to Air Ticket Reservation System ---------------\n\n\n");
        for (int i = 0; i < bookingArray.length; i++) {
            outB.print(bookingArray[i].toString());
        }
        outB.flush();
        outB.close();
        outlog.close();
    }
    
    private static void ADD_Airline(Airline[] airlainArray, Scanner inDB, PrintWriter outlog, int airlainArrayIndex) {
        airlainArray[airlainArrayIndex] = new Airline(inDB.next(), inDB.next(), inDB.next(), inDB.next());
        
    }
    
    private static void ADD_Airport(Airport[] airportArray, Scanner inDB, PrintWriter outlog, int airportArrayIndex) {
        airportArray[airportArrayIndex] = new Airport(inDB.next(), inDB.next(), inDB.next());
        
    }
    
    private static void ADD_Flight(Flight[] flightArray, Scanner inDB, PrintWriter outlog, int flightArrayIndex) {
        flightArray[flightArrayIndex] = new Flight(inDB.next(), inDB.next(), inDB.next(), inDB.nextDouble());
        
    }
    
    private static void ADD_Booking(Booking[] bookingArray, Airline[] airlainArray, Airport[] airportArray, Flight[] flightArray, Scanner inB, int bookingArrayIndex) {
        long bookingNumber = System.currentTimeMillis();
        Flight theFlight = getFlight(flightArray, inB);
        Airline theAirline = getAirline(airlainArray, inB);
        Airport theAirport = getAirport(airportArray, inB);
        Date DateOfTravel = new Date();
        DateOfTravel.setYear(inB.nextInt());
        DateOfTravel.setMonth(inB.nextInt());
        DateOfTravel.setDate(inB.nextInt());
        String name = inB.next();
        Date DateOfBirth = new Date();// use getDate
        DateOfBirth.setYear(inB.nextInt());
        DateOfBirth.setMonth(inB.nextInt());
        DateOfBirth.setDate(inB.nextInt());
        boolean BusinessClass = inB.nextBoolean();
        int BaggageWeight = inB.nextInt();
        
        bookingArray[bookingArrayIndex] = new Booking(bookingNumber, theFlight, theAirline, theAirport, DateOfTravel, name, DateOfBirth, BusinessClass, BaggageWeight);
    }
    
    private static Flight getFlight(Flight[] flightArray, Scanner inB) {
        String flightNumber = inB.next();
        for (int i = 0; i < flightArray.length; i++) {
            if (flightNumber.equalsIgnoreCase(flightArray[i].getFlightNo())) {
                return flightArray[i];
            }
        }
        return null;
    }
    
    private static Airport getAirport(Airport[] airportArray, Scanner inB) {
        String airportThreeLCODE = inB.next();
        for (int i = 0; i < airportArray.length; i++) {
            if (airportThreeLCODE.equalsIgnoreCase(airportArray[i].getThreeDigitCode())) {
                return airportArray[i];
            }
        }
        return null;
    }
    
    private static Airline getAirline(Airline[] airlainArray, Scanner inB) {
        String airlineTwoDCODE = inB.next();
        for (int i = 0; i < airlainArray.length; i++) {
            if (airlineTwoDCODE.equalsIgnoreCase(airlainArray[i].getTwoDigitCode())) {
                return airlainArray[i];
            }
        }
        return null;
    }
    
    private static void printLog(Airline[] airlainArray, Flight[] flightArray, Airport[] airportArray, PrintWriter outlog) {
        for (int i = 0; i < airlainArray.length; i++) {
            outlog.print(airlainArray[i].toString());
        }
        for (int i = 0; i < flightArray.length; i++) {
            outlog.print(flightArray[i].toString());
        }
        for (int i = 0; i < airportArray.length; i++) {
            outlog.print(airportArray[i].toString());
        }
        outlog.flush();
    }
    
}
