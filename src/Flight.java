
/*
 * Name: Ahmed Abdullah Qahtan
 * ID: 2046143
 * Course Number: CPCS203
 * Section: H
 * Date: 2021/3/21
 * Emile: AAHMEDQAHTAN0001@stu.kau.edu.sa  ,   Qahtanqq99@icloud.com
 */
public class Flight {

    private String flightNo;
    private String departure;
    private String destination;
    private double fare;

    public Flight(String flightNo, String departure, String destination, double fare) {
        this.flightNo = flightNo;
        this.departure = departure;
        this.destination = destination;
        this.fare = fare;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public double getFare() {
        return fare;
    }

    @Override
    public String toString() {
        return "(New Flight Added)	Flight No: " + flightNo + "	Departure: " + departure + "	Destination: " + destination + "	Fare: SAR " + fare + "}\n-------------------\n\n";
    }

}
