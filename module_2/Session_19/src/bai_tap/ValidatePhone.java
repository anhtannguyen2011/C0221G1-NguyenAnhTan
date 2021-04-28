package bai_tap;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^\\([0-9]{2}\\)-\\([0]{1}[0-9]{9}\\)$");

        while (true){
            System.out.println("Enter Phone Name");
            String phoneName = scanner.nextLine();
            Matcher matcher = pattern.matcher(phoneName);
            if(matcher.find()){
                System.out.println("Ok");
                break;
            }else {
                System.out.println("Not Ok");
            }
        }

    }
}
