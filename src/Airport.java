/*
 * Name: Ahmed Abdullah Qahtan
 * ID: 2046143
 * Course Number: CPCS203
 * Section: H
 * Date: 2021/3/21
 * Emile: AAHMEDQAHTAN0001@stu.kau.edu.sa  ,   Qahtanqq99@icloud.com
 */
public class Airport {

    private String threeDigitCode;
    private String city;
    private String name;

    public Airport(String threeDigitCode, String city, String name) {
        this.threeDigitCode = threeDigitCode;
        this.city = city;
        this.name = name;
    }

    public void setThreeDigitCode(String threeDigitCode) {
        this.threeDigitCode = threeDigitCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThreeDigitCode() {
        return threeDigitCode;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "(New Airport Added)	Airport Code: " + threeDigitCode + "	City: " + city + "	Name: " + name + "}\n-------------------\n\n";
    }

}
