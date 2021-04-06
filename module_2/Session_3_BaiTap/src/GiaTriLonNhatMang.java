import java.util.Scanner;

public class GiaTriLonNhatMang {
    public static void main(String[] args) {

        int [][] arr = nhap();
        int max = arr[0][0];
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0; j <arr[i].length ; j++){
                if(max < arr[i][j]){
                    max = arr[i][j];
                }
            }
        }
        System.out.println("Giá trị lớn nhất của mảng 2 chiều là :" + max);

    }
    public static int[][] nhap(){
        int row;
        int[][] arr;
        int col;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập Số Dòng : ");
        row = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập Số Cột : ");
        col = Integer.parseInt(scanner.nextLine());
        arr = new int [row][col];
        for(int i = 0 ; i < row ; i++){
            for(int j = 0; j < col ; j++){
                System.out.print("Nhập Phần Tử Thứ ["+i+","+j+"] : ");
                arr[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }
        System.out.println("Show Mảng Vừa Nhập : ");
        for(int i = 0 ; i < row ; i++){
            for(int j = 0; j < col ; j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println("\n");
        }

        return arr;
    }
}
