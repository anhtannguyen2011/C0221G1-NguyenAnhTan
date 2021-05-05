package controllers;

import commons.FileUnits;
import models.Customers;

import java.util.*;

public class Cinema4D {
    public static void controlCinema4D(){
        List<Customers> customersList = FileUnits.fileReadCustomer();
        System.out.println("Rạp Chiếu Film 4D :");
        System.out.println("Nhập số vé Film Ngày Hôm nay");
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        Queue<Customers> queue = new ArrayDeque<>();
        int choose;
        for(int i = 0 ; i < customersList.size();i++){
            System.out.println("Bạn Muốn Mua Vé Không :");
            System.out.println("1. Mua Vé :");
            System.out.println("2. Không Mua :");
            choose = Integer.parseInt(scanner.nextLine());
                switch (choose){
                    case 1:
                        queue.add(customersList.get(i));
                        System.out.println("Ban Đã Mua Được "+(i+1)+" Vé ");
                        System.out.println("Số Vé Còn Lại Là : "+(number - queue.size()));
                        break;
                    case 2:
                        break;
                }


            if(queue.size() == number){
                System.out.println("Thông Báo Hết Vé");
                break;
            }
        }

        System.out.println("SHOW PEOPLE BUY TICKET");
       for(Customers customers : queue){
            System.out.println(customers);
       }
//       Iterator iterator =  queue.iterator();
//       while (iterator.hasNext()){
//           System.out.println(queue);
//       }


    }
}
