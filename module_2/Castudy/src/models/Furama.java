package models;

public abstract class Furama {
    private String id;
    private String nameServices;
    private float areaOfUse;
    private float pricesofRent;
    private int numberPeoples;
    private String typeOfRent;

    public Furama() {
    }

    public Furama(String id, String nameServices, float areaOfUse, float pricesofRent, int numberPeoples, String typeOfRent) {
        this.id = id;
        this.nameServices = nameServices;
        this.areaOfUse = areaOfUse;
        this.pricesofRent = pricesofRent;
        this.numberPeoples = numberPeoples;
        this.typeOfRent = typeOfRent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameServices() {
        return nameServices;
    }

    public void setNameServices(String nameServices) {
        this.nameServices = nameServices;
    }

    public float getAreaOfUse() {
        return areaOfUse;
    }

    public void setAreaOfUse(float areaOfUse) {
        this.areaOfUse = areaOfUse;
    }

    public float getPricesofRent() {
        return pricesofRent;
    }

    public void setPricesofRent(float pricesofRent) {
        this.pricesofRent = pricesofRent;
    }

    public int getNumberPeoples() {
        return numberPeoples;
    }

    public void setNumberPeoples(int numberPeoples) {
        this.numberPeoples = numberPeoples;
    }

    public String getTypeOfRent() {
        return typeOfRent;
    }

    public void setTypeOfRent(String typeOfRent) {
        this.typeOfRent = typeOfRent;
    }

    @Override
    public String toString() {
        return  id+","+nameServices +"," + areaOfUse +"," + pricesofRent +"," + numberPeoples + "," + typeOfRent ;
    }
    public abstract String showInfo();
    public String showServices(){
        return "ID : "+id+"; NameServices : "+nameServices+"; AreaOfUse : "+areaOfUse+"; PriceOfRent :"+pricesofRent+
                "; NumberPeople : "+numberPeoples+"; TypeOfRent : "+typeOfRent;
    }
}
