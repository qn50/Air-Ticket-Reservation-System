/*
 * Name: Ahmed Abdullah Qahtan
 * ID: 2046143
 * Course Number: CPCS203
 * Section: H
 * Date: 2021/3/21
 * Emile: AAHMEDQAHTAN0001@stu.kau.edu.sa  ,   Qahtanqq99@icloud.com
 */
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Booking {

    private long bookingNo;
    private Flight flight;
    private Airline airline;
    private Airport airport;
    Date flightDate;
    private String name;
    private Date dob;
    private boolean isBusinessClass;
    private int baggageWeight;

    public Booking(long bookingNo, Flight flight, Airline airline, Airport airport, Date flightDate, String name, Date dob, boolean isBusinessClass, int baggageWeight) {
        this.bookingNo = bookingNo;
        this.flight = flight;
        this.airline = airline;
        this.airport = airport;
        this.flightDate = flightDate;
        this.name = name;
        this.dob = dob;
        this.isBusinessClass = isBusinessClass;
        this.baggageWeight = baggageWeight;
    }

    public void setBookingNo(long bookingNo) {
        this.bookingNo = bookingNo;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setIsBusinessClass(boolean isBusinessClass) {
        this.isBusinessClass = isBusinessClass;
    }

    public void setBaggageWeight(int baggageWeight) {
        this.baggageWeight = baggageWeight;
    }

    public long getBookingNo() {
        return bookingNo;
    }

    public Flight getFlight() {
        return flight;
    }

    public Airline getAirline() {
        return airline;
    }

    public Airport getAirport() {
        return airport;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public String getName() {
        return name;
    }

    public Date getDob() {
        return dob;
    }

    public boolean isIsBusinessClass() {
        return isBusinessClass;
    }

    public int getBaggageWeight() {
        return baggageWeight;
    }

    public double calculateFare(double fare, boolean isBusinessClass, Date flihgtDate, Date dob, int baggageWeight) {
        int age = flightDate.getYear() - dob.getYear();

        if (isBusinessClass) {
            fare = fare * 1.4;
        }
        if (age <= 2) {
            fare = fare * 0.1;
        } else if (age <= 12) {
            fare = fare * 0.7;
        }
        if (isBusinessClass && baggageWeight > 50) {
            fare = fare + ((baggageWeight - 50) * 30);
        } else if (!isBusinessClass && baggageWeight > 30) {
            fare = fare + ((baggageWeight - 30) * 30);
        }
        fare = Math.round(fare);
        return fare;
    }

    @Override
    public String toString() {
        return "Booking No. " + bookingNo + "\n\n"
                + "Passenger Details	Passenger Name: " + name + "		Date of Birth: " + dob.getYear() + "-" + dob.getDate() + "-" + dob.getMonth()
                + "\n\nFlight Details	Flight Code: " + airline.getTwoDigitCode() + "-" + flight.getFlightNo() + "			" + flightDate.getYear() + "-" + flightDate.getDate() + "-" + flightDate.getMonth()
                + "\n		Departure: " + airport.getThreeDigitCode() + "			Destination: " + flight.getDestination()
                + "\n\nAirport Details	tAirport Name: " + airport.getName() + " (" + airport.getThreeDigitCode() + "), " + airport.getCity()
                + "\n\nAirline Details	Name: " + airline.getName() + " based in " + airline.getWebsite()
                + "\n\nFare Details	Regular Fare: SAR " + flight.getFare()
                + "\n		Total Fare: SAR " + calculateFare(flight.getFare(), isBusinessClass, flightDate, dob, baggageWeight)
                + "\nâ”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€\n";
    }

}
