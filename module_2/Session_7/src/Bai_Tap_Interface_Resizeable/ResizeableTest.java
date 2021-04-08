package Bai_Tap_Interface_Resizeable;

import javax.management.ObjectName;

public class ResizeableTest {
    public static void main(String[] args) {
        double percent = Math.random() * 100;
       Shape[] shapes = new Shape[3];
       shapes[0] = new Circle(1);
       shapes[1] = new Rectangle(7,5);
       shapes[2] = new Square(5);
        System.out.println("Truoc random");
       for(Shape shape : shapes){
           System.out.println(shape);
       }
        System.out.println("Sau khi random :");
       for(Shape shape : shapes){
          shape.resize(percent);
           System.out.println(shape);
       }
//        Circle circle = new Circle();
//        Rectangle rectangle = new Rectangle();
//        Object[] object = new Object[2];
//        circle.resize(percent);
//        rectangle.resize(percent);
//
//        object[0] = circle;
//        object[1] = rectangle;
//        for(Object object1 : object ){
//            System.out.println(object1);
//        }
//        for(Object object1 : object ){
//            object1.re
//            System.out.println(object1);
//        }







    }

}
