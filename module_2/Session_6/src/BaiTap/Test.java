package BaiTap;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập Bán Kính");
        double cr = scanner.nextDouble();
        System.out.println("Nhập Màu Sắc: ");
        String cl = scanner.next();

        Circle circle = new Circle();
//
        System.out.println(circle);


        Circle circle1 = new Circle(cr, cl);

        circle1.getArea();
        System.out.println(circle1.toString());

        Cilinder cilinder = new Cilinder(5);
        System.out.println(cilinder);
        System.out.print("Nhập chiều cao");
        double height = scanner.nextDouble();
        Cilinder cilinder1 = new Cilinder(cr, cl, height);
        System.out.println(cilinder1.toString());
    }
}
