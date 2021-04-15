package optional_baitap;

import java.util.Scanner;
import java.util.Stack;

public class Change {
    private static final char CHAR_55 = 55;
    public void coverBinary(int num) {
        Stack<Integer> stack = new Stack<>();
        int temp = 0;
        while (num != 0) {
            temp = num % 2;
            stack.push(temp);
            num = num / 2;
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }


    }
    public void changeSixteen(int numb){
        Stack<Object> sta = new Stack<>();
        while (numb > 0){
            int temp = numb % 16;
            if (temp>=10){
                sta.push((char) (CHAR_55+ temp));
            }
            else sta.push(temp);
            numb = numb / 16;
        }
        while (!sta.isEmpty()){
            System.out.print(sta.pop());
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Số Cần Chuyển Qua Nhị Phân");

        int number = sc.nextInt();
        Change change = new Change();
        System.out.print("Trước Khi chuyển qua nhị phân : " + number);
        System.out.println();
        System.out.print("Sau Khi chuyển qua nhị phân : ");
        change.coverBinary(number);
        System.out.println();
        System.out.print("Sau Khi chuyển qua thập lục phân : ");
        change.changeSixteen(number);

    }
}
