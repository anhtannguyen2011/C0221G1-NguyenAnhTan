package controllers;

import commons.FileUnits;
import models.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewBooking {
    static Scanner scanner = new Scanner(System.in);
    static List<Customers> listCustomers = FileUnits.fileReadCustomer();
    static List<Furama> furamaList = FileUnits.readFile();
    static final String PATH ="DemoCastudy/src/data/Booking.csv";

    public static void addBooking() {
        CustomersController.showInformation();
        System.out.println("Nhập ID Customers Cần ADD Booking");
        String idBooking = scanner.nextLine();
        boolean check = false;
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        int index = 0;
        try {
            fileWriter = new FileWriter(PATH,true);
            bufferedWriter = new BufferedWriter(fileWriter);
            for(int i = 0; i < listCustomers.size() ;i++){
                if(listCustomers.get(i).getIdCard().equals(idBooking)){
                    check = true;
                    index = i;
                    break;
                }
            }

            if(check){
                System.out.println("Mời Bạn Add New Booking ! ");
                System.out.println("1. Add Booking Villa");
                System.out.println("2. Add Booking House");
                System.out.println("3. Add Booking Room");
                System.out.println("Please Your Choose");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose){
                    case 1:
                        Services.showVilla();
                        List<Villa> villaList = new ArrayList<>();
                        System.out.println("Nhập ID VILLA :");
                        String idVilla = scanner.nextLine();
                        for(Furama villa : furamaList){
                            if(villa instanceof Villa){
                                villaList.add((Villa) villa);
                            }
                        }
                        boolean checkVilla = false;
                        for(int i = 0; i < villaList.size() ; i++){
                            if(villaList.get(i).getId().equals(idVilla)){
                                checkVilla = true;
                                bufferedWriter.write(villaList.get(i).showInfo()+" "+listCustomers.get(index));
                                bufferedWriter.append("\n");
                                System.out.println("Booking SuccessFull!");
                                break;
                            }
                        }
                        if(!checkVilla){
                            System.out.println("Không thể add Booking");
                        }
                        break;
                    case 2:
                        Services.showHouse();
                        List<House> houseList = new ArrayList<>();
                        System.out.println("Nhập ID House :");
                        String idHouse = scanner.nextLine();
                        for(Furama house : furamaList){
                            if(house instanceof House){
                                houseList.add((House) house);
                            }
                        }
                        boolean checkHouse = false;
                        for(int i = 0 ; i< houseList.size() ;i++){
                            if(houseList.get(i).getId().equals(idHouse)){
                                checkHouse = true;
                                bufferedWriter.write(houseList.get(i).showInfo());
                                bufferedWriter.append("\n");
                                System.out.println("Booking SuccessFull !");
                                break;
                            }
                        }
                        if(!checkHouse){
                            System.out.println("Booking fails");
                        }
                        break;
                    case 3:
                        Services.showRoom();
                        List<Room> roomList = new ArrayList<>();
                        System.out.println("Nhập ID Room :");
                        String idRoom = scanner.nextLine();
                        for(Furama room : furamaList){
                            if(room instanceof Room){
                                roomList.add((Room) room);
                            }
                        }
                        boolean checRoom = false;
                        for(int i = 0 ; i< roomList.size() ;i++){
                            if(roomList.get(i).getId().equals(idRoom)){
                                checRoom= true;
                                bufferedWriter.write(roomList.get(i).showInfo());
                                bufferedWriter.append("\n");
                                System.out.println("Booking SuccessFull !");
                                break;
                            }
                        }
                        if(!checRoom){
                            System.out.println("Booking fails");
                        }
                        break;
                }

            }else {
                System.out.println("Không tìm thấy ID Trùng");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();
                fileWriter.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }
}
