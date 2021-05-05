import java.io.*;
import java.util.*;
import java.util.List;
import java.util.Scanner;


public class Menu {


    public static void main(String[] args) {

        //calls menu_display function to start menu
        menu_display();

    }

    public static void menu_display () {

        Scanner in = new Scanner(System.in);

        //creates menu input int
        int user_choice;

        //while loop keeps program running til valid option is selected
        while (true)  {

            //calls menu function and displays it
            menu();

            //allows for user_choice input
            user_choice = in.nextInt();

            //switch case directs user choice to correct function. If input is not those listed, an error is shown.
            switch (user_choice) {
                case 1 -> Logintesting.login();
                case 2 -> Signup.SignUp();
                case 12 -> System.exit(0);
                default -> System.out.println("Invalid input! Try again: ");
            }
        }
    }

    //displays menu
    public static void menu() {
        System.out.println("\n");
        System.out.println("\nLibrary System");
        System.out.println("--------------------");
        System.out.println("Select an option:");
        System.out.println("1: Login");
        System.out.println("2: Sign Up");
        System.out.println("12: Exit");

        System.out.println("Enter an Option");
    }
}

