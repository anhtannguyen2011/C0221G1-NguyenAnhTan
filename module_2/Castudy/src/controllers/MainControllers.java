package controllers;

import commons.RegexMenu;
import exception.*;

import java.util.Scanner;

public class MainControllers {
    static Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu() throws NameException, EmailException, GenderException, IdCardException, BirthDayException {
        while (true) {
            menu();
            System.out.println("Please Choose !!!!");
            String str = scanner.nextLine();
            while (!RegexMenu.checkMainMenu(str)) {
                System.err.println("Please your enter : ");
                str = scanner.nextLine();
            }
            int choose = Integer.parseInt(str);
            switch (choose) {
                case 1:
                    Services.addMenu();
                    break;
                case 2:
                    Services.menuServices();
                    break;
                case 3:
                    CustomersController.addCustomers();
                    break;
                case 4:
                    CustomersController.showInformation();
                    break;
                case 5:
                    NewBooking.addBooking();
                    break;
                case 6:
                    EmployeeController.menuEmployee();
                    break;
                case 7:
                    Cinema4D.controlCinema4D();
                case 8:
                   System.exit(0);

            }

        }
    }

    public static void menu() {
        System.out.println("1. Add New Services\n" +
                "2. Show Services\n" +
                "3. Add New Customer\n" +
                "4. Show Information of Customer\n" +
                "5. Add New Booking\n" +
                "6. Show Information of Employee\n" +
                "7. Cinema4D\n"+
                "8. Exit");
    }

}
