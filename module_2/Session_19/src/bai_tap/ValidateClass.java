package bai_tap;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^[CAP][0-9]{4}[GHIKLM]{1}$");

        while (true){
            System.out.println("Enter Class Name");
            String className  =scanner.nextLine();
            Matcher matcher = pattern.matcher(className);
            if(matcher.find()){
                System.out.println("Ok");
                break;
            }else {
                System.out.println("Not Ok");
            }
        }

    }
}
