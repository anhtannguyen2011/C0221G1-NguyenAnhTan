import java.util.Scanner;

public class XoaPhanTuKhoiMang {
    public static void delete(int[] arr){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào X :");
        int x = Integer.parseInt(scanner.nextLine());
        for(int i = 0 ; i < arr.length ;i++){
            if(arr[i] == x){
                for(int j = i ; j < arr.length -1 ; j++){
                    arr[j] = arr[j + 1];
                }
            }

        }
        arr[arr.length-1]=0;
        for(int i = 0 ; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập Số Phần Tử Của Mảng :");
        int[] arr ;
        int size = Integer.parseInt(input.nextLine());

        arr = new int[size];
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print("Nhập Phần Tử Thứ :" +(i + 1)+  ":");
            arr[i] = Integer.parseInt(input.nextLine());
        }
        delete(arr);
    }
}
