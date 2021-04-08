package Bai_Tap_Interface_Resizeable;

public class Square extends Shape implements Resizeable,Colorable{
    double side;
    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }


    public double getSide() {
        return this.side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea(){
        return this.side * this.side;
    }



    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + getArea();
    }
    @Override
    public void resize(double percent) {
        setSide(getSide() * (percent/100));
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides ...");
    }
}
