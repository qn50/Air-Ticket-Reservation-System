
/*
 * Name: Ahmed Abdullah Qahtan
 * ID: 2046143
 * Course Number: CPCS203
 * Section: H
 * Date: 2021/3/21
 * Emile: AAHMEDQAHTAN0001@stu.kau.edu.sa  ,   Qahtanqq99@icloud.com
 */
public class Airline {

    private String twoDigitCode;
    private String name;
    private String originCountry;
    private String website;

    public Airline(String twoDigitCode, String name, String originCountry, String website) {
        this.twoDigitCode = twoDigitCode;
        this.name = name;
        this.originCountry = originCountry;
        this.website = website;
    }

    public void setTwoDigitCode(String twoDigitCode) {
        this.twoDigitCode = twoDigitCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTwoDigitCode() {
        return twoDigitCode;
    }

    public String getName() {
        return name;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public String getWebsite() {
        return website;
    }

    @Override
    public String toString() {
        return "(New Airline Added)	Airline No.: " + twoDigitCode + "	Airline: " + name + "	Hub: " + originCountry + "	URL: " + website + "}\n-------------------\n\n";
    }

}
