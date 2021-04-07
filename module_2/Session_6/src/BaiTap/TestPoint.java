package BaiTap;

public class TestPoint {
    public static void main(String[] args) {
        Point3D point3D = new Point3D();
        Point2D point2D = new Point2D();
        System.out.println(point2D);
        System.out.println(point3D);
        point2D = new Point2D(2.0f,5.9f);
        point3D = new Point3D(2.0f, 3.5f, 5.7f);
        System.out.println(point2D);
        System.out.println(point3D);
    }
}
