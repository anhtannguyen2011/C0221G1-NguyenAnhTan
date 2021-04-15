package optional_baitap;

import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String string = "Able was I ere I saw Elba";
        char[] array = string.toCharArray();
        boolean check = false;

        System.out.println(array);
        for(int i = 0 ; i < array.length /2 ; i ++){
            if(array[i] == array[array.length - 1 -i]){
                check = true;
            }
        }
        if(check==true){
            System.out.println("Phải là Palindrome");
        }else {
            System.out.println("Không  Phải Palindrome ");
        }
//        for(char c : array){
//            stack.push(c);
//
//        }
//        System.out.println(stack);
//        System.out.println(stack.size());

//        for(int i = 0 ; i > stack.length/2; i++){
//
//        }
//        if(stack.size() %2 == 1){
//            for(int i = 0 ; i < stack.size()/2; i++){
//                if(stack.get(i) == stack.get(stack.size() - i -1)){
//                    check = true;
//                }else {
//                    break;
//                }
//            }
//            if(check == true){
//                System.out.println("Chuỗi là chuỗi Paladindrome");
//            }else {
//                System.out.println("false");
//            }
//        }else {
//            System.out.println("Không phải là chuỗi Paladindrome");
//        }




    }
}
