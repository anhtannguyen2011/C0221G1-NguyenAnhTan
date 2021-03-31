import java.util.Scanner;

public class Bai_Tap_DocSoThanhChu {
    public static String docTu1Den9(int number) {
        String result = "";

        switch (number) {
            case 1:
                result = "one";
                break;
            case 2:
                result = "two";
                break;
            case 3:
                result = "three";
                break;
            case 4:
                result = "four";
                break;
            case 5:
                result = "five";
                break;
            case 6:
                result = "six";
                break;
            case 7:
                result = "seven";
                break;
            case 8:
                result = "eight";
                break;
            case 9:
                result = "nine";
                break;
        }
        return result;
    }

    public static String doctu10den19(int number) {
        String result = "";
        switch (number) {
            case 10:
                result = "ten";
                break;
            case 11:
                result = "eleven";
                break;
            case 12:
                result = "twelve";
                break;
            case 13:
                result = "thirteen";
                break;
            case 15:
                result = "fifteen";
                break;
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
                int soteen = number % 10;
                result = docTu1Den9(soteen) + "teen";
                break;
        }
        return result;
    }

    public static String docHangChuc(int number) {
        String result = "";

        switch (number) {
            case 20:
                result = "twenty";
                break;
            case 30:
                result = "thirty";
                break;
            case 40:
                result = "forty";
                break;
            case 50:
                result = "fifty";
                break;
            case 60:
            case 70:
            case 80:
            case 90:
                int hangChuc = number / 10;
                result = docTu1Den9(hangChuc) + "ty";
                break;
        }
        return result;
    }

    public static String docTu21Den99(int number) {

        int hangChuc = number / 10;
        hangChuc *= 10;
        int hangDonVi = number % 10;
        return docHangChuc(hangChuc) + "" + docTu1Den9(hangDonVi);
    }

    public static String docTu1Den99(int number) {
        if (number < 10) {
            return docTu1Den9(number);
        } else if (number >= 10 && number <= 19) {
            return doctu10den19(number);
        } else {
            return docTu21Den99(number);
        }

    }

    public static String docSo100(int number) {

        return docTu1Den9(number) + "hundred";
    }

    public static String docTu101Den999(int number) {
        int hangTram = number / 100;
        int soDu = number % 100;
        if (soDu == 0) {
            return docSo100(hangTram);
        } else {
            return docSo100(hangTram) + " and " + docTu1Den99(soDu);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập Vào Số Cần Đọc : ");
        int number = scanner.nextInt();
        if (number < 10) {
            System.out.println(docTu1Den9(number));
        } else if (number >= 10 && number <= 19) {
            System.out.println(doctu10den19(number));
        } else if (number >= 21 && number <= 99) {
            System.out.println(docTu21Den99(number));
        } else if (number == 100) {
            System.out.println(docSo100(number));
        } else {
            System.out.println(docTu101Den999(number));
        }
    }
}

