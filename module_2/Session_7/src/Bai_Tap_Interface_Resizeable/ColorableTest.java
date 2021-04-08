package Bai_Tap_Interface_Resizeable;

import java.util.Arrays;

public class ColorableTest {
    public static void main(String[] args) {
      Shape[] shapes = new Shape[3];
      shapes[0] = new Circle(1);
      shapes[1] = new Rectangle(4,2);
      shapes[2] = new Square(5);
        System.out.println("Show Shape");
        for(Shape shape : shapes){
            System.out.println(shape);
        }
        System.out.println("Check");
        for(Shape color : shapes){
            if(color instanceof Colorable){
                System.out.println("Co color :" +"\n" +color);
                ((Colorable) color).howToColor();
            }else {
                System.out.println("ko co color :"+"\n" + color);
            }
        }


    }
}
