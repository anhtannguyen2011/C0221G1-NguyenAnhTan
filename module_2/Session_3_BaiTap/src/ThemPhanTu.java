import java.util.Scanner;

public class ThemPhanTu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập Số Phần Tử Của Mảng :");
        int[] arr ;
        int size = Integer.parseInt(scanner.nextLine());
        arr = new int[size];
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print("Nhập Phần Tử Thứ :" +(i +1)+  ":");
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        chenMang(arr);

    }
    public static void chenMang(int[] arr){
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập Phần Tử Cần Chèn : ");
        int x = Integer.parseInt(input.nextLine());
        System.out.print("Nhập Vị Trí Cần Chèn : ");
        int index = Integer.parseInt(input.nextLine());
        if(index <=1 && index >=arr.length - 1){
            System.out.println("Không Chèn Được Vào Mảng");
        }else {
            for(int i= arr.length - 1 ; i > index - 1  ;i--){
                arr[i] = arr[i - 1];
            }
            arr[index] = x;
        }
        for(int j = 0 ; j < arr.length ; j++){
            System.out.print(arr[j] + " ");
        }
    }
}
