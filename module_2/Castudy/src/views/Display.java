package views;

import controllers.MainControllers;
import controllers.Services;
import exception.*;

public class Display {
    public static void main(String[] args) throws IdCardException, BirthDayException, EmailException, GenderException, NameException {
        MainControllers.displayMainMenu();
    }
}
