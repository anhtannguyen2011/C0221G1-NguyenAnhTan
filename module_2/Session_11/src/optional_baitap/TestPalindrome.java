package optional_baitap;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class TestPalindrome {
    public static void main(String[] args) {
//        System.out.println("Enter your String");
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//        Stack stack =new Stack();
//        for(int i = 0 ; i<input.length();i++){
//            stack.push(input.charAt(i));
//        }
//        String reverseString = "";
//        while (!stack.isEmpty()){
//            reverseString = reverseString + stack.pop();
//        }
//        if(input.equalsIgnoreCase(reverseString)){
//            System.out.println("The input String is a palindrome");
//        }else {
//            System.out.println("The input String is not a paladindrome");
//        }

        System.out.println("Nhập chuỗi vào : ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Stack stack = new Stack();
        Queue<Character> queue = new LinkedList();
        boolean check = true;
        for(int i = 0 ; i < input.length() ; i++){
            stack.push(input.charAt(i));
            queue.add(input.charAt(i));
        }
        for(int i = 0 ; i < input.length() ; i++){
            if(stack.pop() != queue.remove()){
                check = false;
                break;
            }
        }
        if(check == true){
            System.out.println("Đối Xứng");
        }else {
            System.out.println("Không Đối XỨng");
        }


    }
}
