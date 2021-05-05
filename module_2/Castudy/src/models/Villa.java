package models;

public class Villa extends Furama  {
    private String standardRoom;
    private String convenient;
    private float areaPool;
    private int numberOfFloors;

    public Villa() {
    }

    public Villa(String id, String nameServices, float areaOfUse, float pricesofRent, int numberPeoples, String typeOfRent, String standardRoom, String convenient, float areaPool, int numberOfFloors) {
        super(id, nameServices, areaOfUse, pricesofRent, numberPeoples, typeOfRent);
        this.standardRoom = standardRoom;
        this.convenient = convenient;
        this.areaPool = areaPool;
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

    public float getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(float areaPool) {
        this.areaPool = areaPool;
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
        return super.toString() + "," +standardRoom+","+convenient+","+areaPool+","+numberOfFloors;
    }

    @Override
    public String showServices() {
        return "VILLA: "+super.showServices()+"; StandardRoom : "+standardRoom+"; Convenient "+convenient+"; AreaPool :"+areaPool+"; NumberOfFloors : "+numberOfFloors;
    }
}
