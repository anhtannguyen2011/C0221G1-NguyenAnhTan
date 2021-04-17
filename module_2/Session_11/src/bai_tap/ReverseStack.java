package bai_tap;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        System.out.println("Mảng Ban Đầu: " + stack);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("Mảng Sau Khi Push");
        System.out.println(stack);

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
        Stack<String> wStack = new Stack<>();
        wStack.push("Tấn");
        wStack.push("Anh");
        wStack.push("Nguyễn");
        System.out.println("Stack trước khí đảo" + wStack);
        while (!wStack.isEmpty()){
            System.out.println(wStack.pop());
        }


    }

//    private static List<String> reverseStack(List<String> list) {
//        if (list.size() <= 1) {
//            return list;
//        }
//        List<String> reversed = new ArrayList<>();
//        reversed.add(list.get(list.size() - 1));
//        reversed.addAll(reverseStack(list.subList(0, list.size() - 1)));
//        return reversed;
//    }

}
