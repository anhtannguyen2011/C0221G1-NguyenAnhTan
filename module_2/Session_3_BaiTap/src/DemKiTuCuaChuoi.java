import java.util.Scanner;

public class DemKiTuCuaChuoi {
    public static void main(String[] args) {
        String str = "ABCDEFGHTKJKHJKGUKGUIKJB";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập Kí Tự Cần Kiểm Tra : ");
        char kitu = scanner.next().charAt(0);
        int count = 0;
        for(int i = 0 ; i < str.length() ; i++){
            if(str.charAt(i) == kitu){
                count ++;
            }
        }
        System.out.print("Số Lần Xuất Hiện Của Kí Tự Là : " +count);

    }
}
