package BaiTap;

import ThucHanh.Shape;

public class Triangle extends Shape {
    public double side1 =1;
    public double side2= 2;
    public double side3 = 3;

    public Triangle(String color, boolean filled, double side1, double side2, double side3) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }
    public double halfPerimeter(){
        return (getPerimeter()/2);
    }
    public double getPerimeter(){
        return (this.side1+this.side2+this.side3);
    }
    public double getArea(){
        return Math.sqrt(halfPerimeter()*(halfPerimeter()-side1)*(halfPerimeter()-side2)*(halfPerimeter()-side3));
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                ", color=" + super.getColor() +
                ", fillter=" + super.isFilled() +
                ", Area=" + getArea() +
                ", Perimeter=" + getPerimeter() +

                '}';
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        triangle = new Triangle("blue",false,100,100,100);
        System.out.println(triangle);

    }

}
