import java.util.Scanner;

public class Bai_Tap_UngDungChuyenDoiTienTe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập Vào Số USD : ");

        int usd = scanner.nextInt();
        int vnd = usd * 23000;
        System.out.println("Giá Trị VND Là : " +vnd+ " Đồng");
    }
}
