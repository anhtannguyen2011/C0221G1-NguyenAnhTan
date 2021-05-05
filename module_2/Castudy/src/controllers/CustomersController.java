package controllers;

import commons.FileUnits;
import commons.RegexCustomers;
import commons.RegexServices;
import models.Customers;

import java.awt.desktop.SystemSleepEvent;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import exception.*;

public class CustomersController {
    static Scanner scanner = new Scanner(System.in);
     static  List<Customers> customersList = FileUnits.fileReadCustomer();

    public static void addCustomers() {
        String name = null;
        do {
            try{
                System.out.println("Nhập tên khách hàng ");
                name= scanner.nextLine();
                RegexCustomers.checkNameCustomers(name);
                break;
            }catch (NameException e){
                System.err.println(e.getMessage());
            }
        }while (true);



        String dayOfBirth = null;
        while (true){
            try{
                System.out.println("Nhập ngày sinh ");
                dayOfBirth = scanner.nextLine();
                RegexCustomers.regexBirth(dayOfBirth);
                break;
            }catch (BirthDayException e){
                System.err.println(e.getMessage());
            }


        }

        String gender =null;
        while (true){
            try {
                System.out.println("Nhập giới tính :");
                gender = scanner.nextLine();
                RegexCustomers.regexGender(gender);
                break;
            }catch (GenderException e){
                System.err.println(e.getMessage());
            }

        }


        String idCard = null;
        while (true){
            try{
                System.out.println("Nhập số CMND :");
                idCard = scanner.nextLine();
                RegexCustomers.regexId(idCard);
                break;
            }catch (IdCardException e){
                System.err.println(e.getMessage());
            }
        }

        System.out.println("Nhập số điện thoại :");
        String phone = scanner.nextLine();
        while (!RegexCustomers.regexPhone(phone)){
            System.err.println("Bạn Nhập Sai Rồi - Vui Lòng Nhập Lại :");
            phone = scanner.nextLine();
        }


        String email = null;
        while (true){
            try{
                System.out.println("Nhập Email : ");
                email =scanner.nextLine();
                RegexCustomers.checkEmail(email);
                break;
            }catch (EmailException e){
                System.err.println(e.getMessage());
            }


        }
        System.out.println("Nhập loại khách : ");
        String typeOfCus = scanner.nextLine();
        while (!RegexCustomers.regexKindOfCus(typeOfCus)){
            System.err.println("Bạn Nhập Sai Rồi - Vui Lòng Nhập Lại :");
            typeOfCus = scanner.nextLine();
        }
        System.out.println("Địa chỉ : ");
        String address = scanner.nextLine();
        Customers customers = new Customers(name,dayOfBirth,gender,idCard,phone,email,typeOfCus,address);
        customersList.add(customers);
        FileUnits.fileWriteCustomers(customersList,false);


    }
    public static void showInformation(){
        customersList.sort(Comparator.comparing(Customers::getName).thenComparing(Customers::getDayOfBirth));
        for(Customers customers : customersList ){
            System.out.println(customers);
        }
    }
}
