package ThucHanh_KhoiHinhHoc;

import java.util.Arrays;

public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle[] circles = new ComparableCircle[2];
        circles[0] = new ComparableCircle(3.6);

        circles[1] = new ComparableCircle(3.5,"Blue");

        System.out.println("Pre-sorted");
        for (ComparableCircle circle : circles){
            System.out.println(circle);
        }
        Arrays.sort(circles);

        System.out.println("After-sorted");
        for(ComparableCircle circle : circles){
            System.out.println(circle);
        }
    }
}
