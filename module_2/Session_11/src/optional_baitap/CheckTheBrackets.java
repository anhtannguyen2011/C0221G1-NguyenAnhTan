package optional_baitap;

import java.util.Stack;

public class CheckTheBrackets {

//        String string = "[()]";
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < string.length(); i++) {
//            if (string.charAt(i) == '{' || string.charAt(i) == '[' || string.charAt(i) == '(') {
//                stack.push(string.charAt(i));
//            }else if(!stack.isEmpty()) {
//                if (string.charAt(i) == '}' && stack.peek() == '{') {
//                    stack.pop();
//                } else if (string.charAt(i) == ']' && stack.peek() == '[') {
//                    stack.pop();
//                } else if (string.charAt(i) == ')' && stack.peek() == '(') {
//                    stack.pop();
//                }
//            } else {
//                stack.push(string.charAt(i));
//            }
//        }
//        if (stack.isEmpty()) {
//            System.out.println("Hợp Lệ");
//        } else {
//            System.out.println("Không Hợp Lệ");
//        }


    public static void main(String[] args) {
        String str = "s * (s – a) * (s – b) * (s – c)";
        Stack<Character> stack = new Stack<>();
      for(int i = 0; i < str.length() ; i++){
          if(str.charAt(i) == '('){
              stack.push(str.charAt(i));
          }
          else if(str.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '('){
              stack.pop();
          }else if (str.charAt(i) == ')'){
              stack.push(str.charAt(i));
          }
      }
        if (stack.isEmpty()) {
            System.out.println("Đúng");
        }else {
            System.out.println("Sai");
        }
    }
}

