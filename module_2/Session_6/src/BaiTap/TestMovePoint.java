package BaiTap;

import javax.crypto.spec.PSource;

public class TestMovePoint {
    public static void main(String[] args) {
        Point point;
        point = new Point();
        System.out.println(point);
        point = new Point(1.2f,1.3f);
        System.out.println(point);
        MoveablePoint moveablePoint;
        moveablePoint = new MoveablePoint();
        System.out.println(moveablePoint);
        moveablePoint = new MoveablePoint(1,3,5,7);
        System.out.println(moveablePoint);
        System.out.println(moveablePoint.move());

    }


}
