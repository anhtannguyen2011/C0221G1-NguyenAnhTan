package controllers;

import commons.FileUnits;
import commons.RegexMenu;
import commons.RegexServices;
import models.Furama;
import models.House;
import models.Room;
import models.Villa;
import exception.*;

import java.io.FileReader;
import java.util.*;

public class Services {
    static Scanner scanner = new Scanner(System.in);
    static List<Furama> furamaList = FileUnits.readFile();

    public static void addMenu(){
        while (true){
            System.out.println("1.\tAdd New Villa\n" +
                    "2.Add New House\n" +
                    "3.Add New Room\n" +
                    "4.Back to menu\n" +
                    "5.Exit\n");
            System.out.println("Nhập thông cần thiết");

            String str = scanner.nextLine();
            while (!RegexMenu.checkAddMenu(str)){
                System.out.println("Pre-enter :");
                str =scanner.nextLine();
            }
            int choose = Integer.parseInt(str);
            switch (choose){
                case 1:addNewVilla();
                break;
                case 2:addNewHouse();
                break;
                case 3:addNewRoom();
                break;
                case 4:
                    return;
                case 5:System.exit(0);

            }


        }


    }

    public static void addNewVilla(){
        System.out.println("Nhập ID Villa :");
        String id = scanner.nextLine();
        while (!RegexServices.checkIdVilla(id)){
            System.err.println("Bạn đã sai xin nhập lại");
            id = scanner.nextLine();
        }
        System.out.println("Nhập Name Dịch vụ");
        String nameServices = scanner.nextLine();
        while (!RegexServices.checkNameServices(nameServices)){
            System.err.println("Vui Lòng Nhập Lại");
            nameServices = scanner.nextLine();
        }
        System.out.println("Nhập diện tích sử dụng ");
        String checkArea = scanner.nextLine();
        while (!RegexServices.checkAreaUser(checkArea)){
            System.err.println("Vui Lòng Nhập Lại");
            checkArea = scanner.nextLine();
        }
        float areaOfUse = Float.parseFloat(checkArea);
        System.out.println("Nhập giá thuê :");
        String checkPrices = scanner.nextLine();
        while (!RegexServices.checkPrices(checkPrices)){
            System.err.println("Vui lòng nhập lại : ");
            checkPrices = scanner.nextLine();
        }
        float pricesOfRent = Float.parseFloat(checkPrices);

        System.out.println("Nhập số người :");
        String checkPeople = scanner.nextLine();
        while (!RegexServices.checkNumberPeople(checkPeople)){
            System.err.println("Vui lòng nhập lại :");
            checkPeople = scanner.nextLine();
        }
        int numberPeople = Integer.parseInt(checkPeople);
        System.out.println("Nhập kiểu thuê :");
        String tyofRent = scanner.nextLine();
        while (!RegexServices.checkTypeOfRent(tyofRent)){
            System.err.println("Vui lòng nhập lại :");
            tyofRent = scanner.nextLine();
        }
        System.out.println("Nhập kiểu Phòng :");
        String standardRoom = scanner.nextLine();
        while (!RegexServices.checkTypeOfRoom(standardRoom)){
            System.err.println("Vui lòng nhập lại ");
            standardRoom = scanner.nextLine();
        }
        System.out.println("Mô tả tiện nghi :");
        String convenitent = scanner.nextLine();
        while (!RegexServices.checkConvenient(convenitent)){
            System.err.println("Vui lòng nhập lại");
            convenitent = scanner.nextLine();
        }

        System.out.println("Diện tích hồ bơi :");
        float areaPool = Float.parseFloat(scanner.nextLine());
        while (areaPool < 30){
            System.out.println("Vui Lòng Nhập Lại");
            areaPool = Float.parseFloat(scanner.nextLine());
        }
        System.out.println("Số Tầng : ");
        int numberOfFloors = Integer.parseInt(scanner.nextLine());
        Furama villa = new Villa(id, nameServices, areaOfUse, pricesOfRent, numberPeople, tyofRent, standardRoom, convenitent, areaPool, numberOfFloors);
        furamaList.add(villa);
        FileUnits.writeFile(furamaList, false);


    }

    public static void showVilla() {
        for (Furama villa : furamaList) {
            if (villa instanceof Villa) {
                System.out.println(villa.showServices());
            }
        }
    }

    public static void addNewHouse() {
        //String id, String nameServices, float areaOfUse, float pricesofRent, int numberPeoples, String typeOfRent, String standardRoom, String convenient, int numberOfFloors
        System.out.println("Nhập ID House :");
        String id = scanner.nextLine();
        while (!RegexServices.checkIDHouse(id)){
            System.err.println("Bạn đã sai xin nhập lại");
            id = scanner.nextLine();
        }

        System.out.println("Nhập Name Dịch vụ");
        String nameServices = scanner.nextLine();
        while (!RegexServices.checkNameServices(nameServices)){
            System.err.println("Vui Lòng Nhập Lại");
            nameServices = scanner.nextLine();
        }
        System.out.println("Nhập diện tích sử dụng ");
        String checkArea = scanner.nextLine();
        while (!RegexServices.checkAreaUser(checkArea)){
            System.err.println("Vui Lòng Nhập Lại");
            checkArea = scanner.nextLine();
        }
        float areaOfUse = Float.parseFloat(checkArea);
        System.out.println("Nhập giá thuê :");
        String checkPrices = scanner.nextLine();
        while (!RegexServices.checkPrices(checkPrices)){
            System.err.println("Vui lòng nhập lại : ");
            checkPrices = scanner.nextLine();
        }
        float pricesOfRent = Float.parseFloat(checkPrices);

        System.out.println("Nhập số người :");
        String checkPeople = scanner.nextLine();
        while (!RegexServices.checkNumberPeople(checkPeople)){
            System.err.println("Vui lòng nhập lại :");
            checkPeople = scanner.nextLine();
        }
        int numberPeople = Integer.parseInt(checkPeople);
        System.out.println("Nhập kiểu thuê :");
        String tyofRent = scanner.nextLine();
        while (!RegexServices.checkTypeOfRent(tyofRent)){
            System.err.println("Vui lòng nhập lại :");
            tyofRent = scanner.nextLine();
        }
        System.out.println("Nhập kiểu Phòng :");
        String standardRoom = scanner.nextLine();
        while (!RegexServices.checkTypeOfRoom(standardRoom)){
            System.err.println("Vui lòng nhập lại ");
            standardRoom = scanner.nextLine();
        }
        System.out.println("Mô tả tiện nghi :");
        String convenitent = scanner.nextLine();
        while (!RegexServices.checkConvenient(convenitent)){
            System.err.println("Vui lòng nhập lại");
            convenitent = scanner.nextLine();
        }
        System.out.println("Số Tầng : ");
        int numberOfFloors = Integer.parseInt(scanner.nextLine());
        Furama house = new House(id, nameServices, areaOfUse, pricesOfRent, numberPeople, tyofRent, standardRoom, convenitent, numberOfFloors);
        furamaList.add(house);
        FileUnits.writeFile(furamaList, false);
    }

    public static void addNewRoom() {
        //String id, String nameServices, float areaOfUse, float pricesofRent, int numberPeoples, String typeOfRent, String freeServices
        System.out.println("Nhập ID Room :");
        String id = scanner.nextLine();
        while (!RegexServices.checkIDRoom(id)){
            System.err.println("Bạn đã sai xin nhập lại");
            id = scanner.nextLine();
        }
        System.out.println("Nhập Name Dịch vụ");
        String nameServices = scanner.nextLine();
        while (!RegexServices.checkNameServices(nameServices)){
            System.err.println("Vui Lòng Nhập Lại");
            nameServices = scanner.nextLine();
        }
        System.out.println("Nhập diện tích sử dụng ");
        String checkArea = scanner.nextLine();
        while (!RegexServices.checkAreaUser(checkArea)){
            System.err.println("Vui Lòng Nhập Lại");
            checkArea = scanner.nextLine();
        }
        float areaOfUse = Float.parseFloat(checkArea);
        System.out.println("Nhập giá thuê :");
        String checkPrices = scanner.nextLine();
        while (!RegexServices.checkPrices(checkPrices)){
            System.err.println("Vui lòng nhập lại : ");
            checkPrices = scanner.nextLine();
        }
        float pricesOfRent = Float.parseFloat(checkPrices);

        System.out.println("Nhập số người :");
        String checkPeople = scanner.nextLine();
        while (!RegexServices.checkNumberPeople(checkPeople)){
            System.err.println("Vui lòng nhập lại :");
            checkPeople = scanner.nextLine();
        }
        int numberPeople = Integer.parseInt(checkPeople);
        System.out.println("Nhập kiểu thuê :");
        String tyofRent = scanner.nextLine();
        while (!RegexServices.checkTypeOfRent(tyofRent)){
            System.err.println("Vui lòng nhập lại :");
            tyofRent = scanner.nextLine();
        }
        System.out.println("Dịch vụ miễn phí : ");
        String freeServices = scanner.nextLine();

        Furama room = new Room(id, nameServices, areaOfUse, pricesOfRent, numberPeople, tyofRent, freeServices);
        furamaList.add(room);
        FileUnits.writeFile(furamaList, false);
    }

    public static void menuServices() {
       while (true){
           System.out.println("1.Show all Villa\n" +
                   "2. Show all House\n" +
                   "3. Show all Room\n" +
                   "4. Show All Name Villa Not Duplicate\n" +
                   "5. Show All Name House Not Duplicate\n" +
                   "6. Show All Name Name Not Duplicate\n" +
                   "7. Back to menu\n" +
                   "8. Exit\n");
           String str = scanner.nextLine();
           while (!RegexMenu.checkServicesMenu(str)) {
               System.out.println("Nhập lại :");
               str = scanner.nextLine();
           }
           int choose = Integer.parseInt(str);
           switch (choose) {
               case 1:
                   showVilla();
                   break;
               case 2:
                   showHouse();
                   break;
               case 3:
                   showRoom();
                   break;
               case 4:
                   showVillaNotDuplicate();
                   break;
               case 5:
                   showHouseNotDuplicate();
                   break;
               case 6:
                   showRoomNotDuplicate();
                   break;
               case 7:
                   return;
               case 8:
                   System.exit(0);


           }
       }

    }

    public static void showRoomNotDuplicate() {
        Set<Room> rooms = new TreeSet<>(Comparator.comparing(Room::getId));
        for(Furama furama : furamaList){
            if(furama instanceof Room){
                rooms.add((Room) furama);
            }
        }
        int number = 1;
        for(Room room1 : rooms){
            System.out.println(number+"."+room1.showServices());
            number++;
        }
    }

    public static void showHouseNotDuplicate() {
        Set<House> houses = new TreeSet<>(Comparator.comparing(House::getId));
        for(Furama furama : furamaList){
            if(furama instanceof House){
                houses.add((House) furama);
            }
        }
        int number = 1;
        for(House house : houses){
            System.out.println(number+"."+house.showServices());
            number++;
        }
    }

    public static void showVillaNotDuplicate() {
        Set<Villa> villas = new TreeSet<>(Comparator.comparing(Villa::getId));
        for(Furama furama : furamaList){
            if(furama instanceof Villa){
                villas.add((Villa) furama);
            }
        }
        int number = 1;
        for(Villa villa : villas){
            System.out.println(number+"."+villa.showServices());
            number++;
        }
    }

    public static void showRoom() {
        for(Furama room : furamaList){
            if(room instanceof Room){
                System.out.println(room.showServices());
            }
        }
    }

    public static void showHouse() {
        for(Furama house : furamaList){
            if(house instanceof House){
                System.out.println(house.showServices());
            }
        }
    }
}
