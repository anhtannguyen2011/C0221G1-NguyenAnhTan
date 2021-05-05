package commons;

import java.util.regex.Pattern;

public class RegexMenu {
    public static boolean checkMainMenu(String str){
        String regex = "^[1-7]{1}$";
        return Pattern.matches(regex,str);
    }
    public static boolean checkServicesMenu(String str){
        String regex = "^[1-8]{1}$";
        return Pattern.matches(regex,str);
    }
    public static boolean checkAddMenu(String str){
        String regex = "^[1-5]{1}$";
        return Pattern.matches(regex,str);
    }

}
