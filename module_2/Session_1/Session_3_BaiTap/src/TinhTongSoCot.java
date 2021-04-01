import java.util.Scanner;

public class TinhTongSoCot {
    public static void main(String[] args){
        int arr[][] = {
                {1,2,3,4,5,6},
                {5,6,7,8,9,10}
        };
        int total = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Số Cột Cần Tính Tổng");
        int col = Integer.parseInt(scanner.nextLine());
        for(int i = 0 ; i < arr.length ; i++){
           total += arr[i][col];
        }
        System.out.println(total);
        enterArray();
    }
    public static void enterArray(){
        int arr[][];
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập Số Hàng Của Mảng : ");
        int row = Integer.parseInt(input.nextLine());
        System.out.println("Nhập số cột của mảng : ");
        int col = Integer.parseInt(input.nextLine());
        arr = new int[row][col];
        for (int i = 0 ; i < row; i++){
            for (int j = 0 ; j <col ; j++){
                System.out.print("Nhập Số Phần Tủ Của Mảng 2 Chiều : ["+i+","+j+"] : ");
                arr[i][j] = Integer.parseInt(input.nextLine());
            }
        }
        System.out.println("Show Số Phần Tử Của Mảng ");
        for(int i = 0; i< row ; i++){
            for(int j = 0; j < col ; j++){
                System.out.print(arr[i][j] + "\t");
            }
        }
        System.out.println("\n");
    }
}
