package thuc_hanh;

import java.util.Random;
import java.util.Scanner;

public class ArrayExample {
    public Integer[] createRandom(){
        Random random = new Random();
        Integer[] arr = new Integer[100];
        System.out.print("Danh Sách Phần Tử Của Mảng : ");
        for(int i =0; i < 100; i++){
            arr[i] = random.nextInt(100);
            System.out.print(arr[i]+ " ");
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayExample arrayExample = new ArrayExample();
        Integer[] arr = arrayExample.createRandom();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Vui Lòng Nhập Chỉ Số 1 Phần tử bất kì");
        int x= scanner.nextInt();
        try {
            System.out.println("Giá trị của phần tử có chỉ số 5" + x + " là " + arr[x]);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Chỉ Số của mảng vượt giới hạn");
        }
    }
}
