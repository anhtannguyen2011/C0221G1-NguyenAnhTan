package models;

public class House extends Furama {
    private String standardRoom;
    private String convenient;
    private int numberOfFloors;

    public House() {
    }

    public House(String id, String nameServices, float areaOfUse, float pricesofRent, int numberPeoples, String typeOfRent, String standardRoom, String convenient, int numberOfFloors) {
        super(id, nameServices, areaOfUse, pricesofRent, numberPeoples, typeOfRent);
        this.standardRoom = standardRoom;
        this.convenient = convenient;
        this.numberOfFloors = numberOfFloors;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getConvenient() {
        return convenient;
    }

    public void setConvenient(String convenient) {
        this.convenient = convenient;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    // private String standardRoom;
    //    private String convenient;
    //    private float areaPool;
    //    private int numberOfFloors;
    @Override
    public String showInfo() {
        return super.toString() +","+standardRoom+","+convenient+","+numberOfFloors;
    }

    @Override
    public String showServices() {
        return "House : "+super.showServices()+"; StandardRoom : "+standardRoom+"; Convenient "+convenient+"; NumberOfFloors : "+numberOfFloors;
    }

}
