import java.util.Scanner;

public class LopHinhChuNhat {
    double a;
    double b;

    public LopHinhChuNhat(double a, double b){
        this.a = a;
        this.b = b;
    }
    public double getArea(){
        return this.a * this.b;
    }
    public double getPeriemeter(){
        return (this.a + this.b) * 2;
    }

    public String display(){
        return "HinhChuNhat {"+"Dài="+ a + ", Rộng =" +b+ "}";
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập Chiều Dài : ");
        double a = sc.nextDouble();
        System.out.println("Nhập Chiều Rộng : ");
        double b = sc.nextDouble();

        LopHinhChuNhat hinhchunhat = new LopHinhChuNhat(a,b);

        System.out.println("Hình Chữ Nhật : \n" +hinhchunhat.display());
        System.out.println("DienTich : \n" +hinhchunhat.getPeriemeter());
        System.out.println("Chu vi : \n" +hinhchunhat.getArea());

    }
}
