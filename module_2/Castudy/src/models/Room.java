package models;

public class Room extends Furama {
    private String freeServices;

    public Room() {
    }

    public Room(String id, String nameServices, float areaOfUse, float pricesofRent, int numberPeoples, String typeOfRent, String freeServices) {
        super(id, nameServices, areaOfUse, pricesofRent, numberPeoples, typeOfRent);
        this.freeServices = freeServices;
    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }

    @Override
    public String showInfo() {
        return super.toString() +","+freeServices;
    }

    @Override
    public String showServices() {
        return "ROOM :" +super.showServices()+"; FreeServices : "+freeServices;
    }
}
