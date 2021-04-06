import java.util.Scanner;

public class TimGiaTriNhoNhatCuaMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập Số Lượng Phần Tử Trong Mảng : ");
        int number = Integer.parseInt(scanner.nextLine());
        int arr[];
        arr = new int[number];
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print("Nhập Phần Tử Thứ " +(i+1) +" : ");
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Show Mảng Vừa Nhập : ");
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i]+ "\t");
        }
        int index = 1 ;
        int min = arr[0];
        for(int i = 1 ; i < arr.length ;i++){
            if(min > arr[i]){
                min = arr[i];
                index = i;
            }
        }
        System.out.print("Giá Trị Nhỏ Nhất Trong Mảng Là : " + min + " Ở Vị Trí Thứ : " +index);

    }
}
