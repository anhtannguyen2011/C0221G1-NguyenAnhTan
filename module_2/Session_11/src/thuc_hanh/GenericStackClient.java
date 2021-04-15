package thuc_hanh;

public class GenericStackClient {
    private static void stack0fStrings() {
        MyGenericStack<String> stack = new MyGenericStack<>();
        stack.push("Five");
        stack.push("four");
        stack.push("Three");
        stack.push("Two");
        stack.push("One");

        System.out.println("1.1 Size of stack after push operation : " + stack.size());
        System.out.println("1.2 Pop elements from stack :");
        while (!stack.isEmpty()) {
            System.out.printf("%s", stack.pop());
        }
        System.out.println("\n 1.3. Size of stack after pop operations : " + stack.size());
    }

    public static void stackOfInterger() {
        MyGenericStack<Integer> stack = new MyGenericStack();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        System.out.println("2.1. Size of stack after push opertaion" + stack.size());

        System.out.println("2.2. Pop elements from stack :");
        while (!stack.isEmpty()) {
            System.out.printf(" %d", stack.pop());
        }
        System.out.println("\n3.3 Size of stack after pop operations : " + stack.size());
    }

    public static void main(String[] args) {
        System.out.println("1. Stack of intergers");
        stackOfInterger();
        System.out.println("2. Stack of String ");
        stack0fStrings();
    }
}

