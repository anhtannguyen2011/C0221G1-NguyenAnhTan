package models;

public class Customers {
    private String name;
    private String dayOfBirth;
    private String gender;
    private String idCard;
    private String phoneNumber;
    private String emial;
    private String typeOfCustomers;
    private String address;
//    private Furama useFurama;

    public Customers(String name, String dayOfBirth, String gender, String idCard, String phoneNumber, String emial, String typeOfCustomers, String address) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.emial = emial;
        this.typeOfCustomers = typeOfCustomers;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmial() {
        return emial;
    }

    public void setEmial(String emial) {
        this.emial = emial;
    }

    public String getTypeOfCustomers() {
        return typeOfCustomers;
    }

    public void setTypeOfCustomers(String typeOfCustomers) {
        this.typeOfCustomers = typeOfCustomers;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return
                name +
                "," + dayOfBirth +
                "," + gender +
                "," + idCard +
                "," + phoneNumber +
                "," + emial +
                "," + typeOfCustomers +
                "," + address ;

    }
}
