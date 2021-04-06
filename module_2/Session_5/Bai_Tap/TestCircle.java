package Bai_Tap;


import java.util.Scanner;

public class TestCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Radius : ");
        double radius = sc.nextDouble();
        Circle cr = new Circle(radius);
        System.out.println(cr.getRadius()+" " +cr.getArea());
    }
}
