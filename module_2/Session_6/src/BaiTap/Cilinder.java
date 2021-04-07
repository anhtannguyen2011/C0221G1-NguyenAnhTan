package BaiTap;

public class Cilinder extends Circle {
    private double height;

    public Cilinder(double height) {
        this.height = height;
    }

    public Cilinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getAreaCilinder(){
        return 2 * Math.PI * (getRadius()+getHeight());
    }   

    @Override
    public String toString() {
        return "Cilinder{" +
                "height=" + height +
                "color=" + getColor() +
                "Area=" + getAreaCilinder() +
                '}';
    }
}
