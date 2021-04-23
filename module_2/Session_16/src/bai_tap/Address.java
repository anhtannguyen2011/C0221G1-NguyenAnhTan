package bai_tap;

public class Address {
    private String lastName;
    private String firstName;
    private String street;
    private String district;
    private String city;
    public Address(String lastName, String firstName, String street, String district, String city) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.street = street;
        this.district = district;
        this.city = city;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getStreet() {
        return street;
    }
    public String getDistrict() {
        return district;
    }
    public String getCity() {
        return city;
    }
}
