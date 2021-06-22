package uta.edu.Shopping;

/**
 * Stores all details related to a physical address.
 */
public class Address {
    private int streetNumber;
    private String streetName;
    private String streetType;
    private String city;
    private String state;
    private String country;

    /**
     * Creates a new Address object.
     * @param sNum The street number (e.g. 909).
     * @param sName The name of the street.
     * @param sType Type of street (e.g. Blvd.).
     * @param city Name of the city.
     * @param state The state that the city is located in.
     * @param country The country that the state is located in.
     */
    public Address(int sNum, String sName, String sType, String city, String state, String country) {
        this.streetNumber = sNum;
        this.streetName = sName;
        this.streetType = sType;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetNumber=" + streetNumber +
                ", streetName='" + streetName + '\'' +
                ", streetType='" + streetType + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
