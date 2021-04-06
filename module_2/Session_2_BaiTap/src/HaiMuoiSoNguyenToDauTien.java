import java.util.Scanner;

public class HaiMuoiSoNguyenToDauTien {
    public static void main(String[] args) {
        int number;
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập Số Nguyên Tố Cần In Ra :");
        number = Integer.parseInt(input.nextLine());
        int count = 0;
        int n = 2;
        while (count < number){
            boolean check = true;
            if(n < 2){
                check = false;
            }else {
                for(int i = 2 ; i < n ; i++){
                    if(n % i ==0){
                        check = false;
                        break;
                    }
                }
            }
            if(check){
                count++;
                System.out.print( n + " ");
            }
            n++;
        }
    }
}
