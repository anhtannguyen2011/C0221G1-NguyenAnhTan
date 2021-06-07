package common;

public class Validate {
    static String message = null;
    public static String regexCodeCustomer(String string){
        String regex = "^(KH)-[0-9]{4}$";
        if(!string.matches(regex)){
            message = "Invalid - (KH-XXXX)";
        }
        return message;
    }
    public static String regexCodeService(String string){
        String regex = "^(DV)-[0-9]{4}$";
        if(!string.matches(regex)){
            message ="Invalid - (DV-XXXX)";
        }
        return message;
    }

    public static String regexPhone(String string){
        String regex = "(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}$";
        if(!string.matches(regex)){
            message ="Invalid - 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx";
        }
        return message;
    }

    public static String regexIdCard(String string){
        String regex = "^[0-9]{9}|[0-9]{12}$";
        if(!string.matches(regex)){
            message ="Invalid - xxxxxxxxx or xxxxxxxxxxxx";
        }
        return message;
    }
    public static String regexEmail(String string){
        String regex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$";
        if(!string.matches(regex)){
            message ="Invalid - xxxx@xxx.xxx";
        }
        return message;
    }

    public static String regexDate(String string){
        String regex = "^([012][0-9]{1}|3[01]{1})\\/(0{1}[1-9]{1}|1[012]{1})\\/[12]{1}[0-9]{3}$";
        if(!string.matches(regex)){
            message ="Invalid - DD/MM/YYYY";
        }
        return message;
    }

    public static String regexNumber(String string){
        String regex ="^[0-9]{1,}[0-9]*$";
        if(!string.matches(regex)){
            message ="Invalid - positive numbers";
        }
        return message;
    }


}
