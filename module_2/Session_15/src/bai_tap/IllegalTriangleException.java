package bai_tap;

import java.util.Scanner;

public class IllegalTriangleException extends Exception {
    String errorMessage;
    public IllegalTriangleException(String isErrorMessage){
        errorMessage = isErrorMessage;
    }
    public String getErrorMessage(){
        return errorMessage;
    }
    public static void TriangleException(int a, int b, int c) throws IllegalTriangleException{
        if(a+b<c||a+c<b||c+b<a||a<0||b<0||c<0){
            throw new IllegalTriangleException("Not a triangle");
        }
    }
    public static void main(String[] args) throws IllegalTriangleException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 3 triangle edges");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        try{
            TriangleException(a,b,c);
            System.out.println("Yeah ! This is 3 triangle edges ");
        }catch (IllegalTriangleException e){
            System.err.println(e.errorMessage);
        }

    }
}
