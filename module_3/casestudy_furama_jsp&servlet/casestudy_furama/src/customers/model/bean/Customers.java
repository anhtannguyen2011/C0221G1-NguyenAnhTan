package customers.model.bean;

import java.util.Date;

public class Customers {
    private int id;
    private String name;
    private String dayOfBirth;
    private int idCard;
    private int phone;
    private String email;
    private String address;
    private int id_typeOfCustomer;

    public Customers() {
    }

    public Customers(int id, String name, String dayOfBirth, int idCard, int phone, String email, String address, int id_typeOfCustomer) {
        this.id = id;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.id_typeOfCustomer = id_typeOfCustomer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId_typeOfCustomer() {
        return id_typeOfCustomer;
    }

    public void setId_typeOfCustomer(int id_typeOfCustomer) {
        this.id_typeOfCustomer = id_typeOfCustomer;
    }
}
