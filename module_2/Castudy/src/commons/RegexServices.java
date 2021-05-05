package commons;

import java.util.regex.Pattern;

public class RegexServices {
    public static boolean checkIdVilla(String string){
        String regex = "^(SVVL)-[0-9]{4}$";
        return Pattern.matches(regex,string);
    }
    public static boolean checkIDHouse(String str){
        String regex = "^(SVHO)-[0-9]{4}$";
        return Pattern.matches(regex,str);
    }
    public static boolean checkIDRoom(String str){
        String regex = "^(SVRO)-[0-9]{4}$";
        return Pattern.matches(regex,str);
    }
    public static boolean checkNameServices(String string){
        String regex ="^[A-Z][a-z]+$";
        return Pattern.matches(regex,string);
    }
    public static boolean checkAreaUser(String string){
        String regex = "^([3-9][0-9].[0-9]{0,}|[1-9]{3,}+)$";
        return Pattern.matches(regex,string);
    }
    public static boolean checkPrices(String string){
        String regex = "^[1-9][0-9]{0,}$";
        return Pattern.matches(regex,string);
    }
    public static boolean checkNumberPeople(String string){
        String regex = "^([1-9]{1}|1[0-9]{1}|20)$";
        return Pattern.matches(regex,string);
    }
    public static boolean checkConvenient(String string){
        String regex = "(massage|karaoke|food|drink|car)";
        return Pattern.matches(regex,string);
    }
    public static boolean checkTypeOfRent(String string){
        String regex ="^[A-Z][a-z]+$";
        return Pattern.matches(regex,string);
    }

    public static boolean checkTypeOfRoom(String string){
        String regex = "^(Premium|DoubleBed|Standard)$";
        return Pattern.matches(regex,string);
    }

}
