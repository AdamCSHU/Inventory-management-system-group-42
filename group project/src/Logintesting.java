import java.io.*;
import java.util.*;

public class Logintesting {

    private static Scanner x;

    public static void main(String[] args) {

    }

    public static void login() {
        Scanner in = new Scanner(System.in);

        System.out.println("Username: ");
        String username = in.next();
        System.out.println("Password; ");
        String password = in.next();
        String filepath = "members.txt";

        loginverify(username,password,filepath);
    }

    public static void loginverify (String username, String password, String filepath) {
        boolean found = false;
        String tempuser = "";
        String temppass = "";

        try {
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while(x.hasNext() && !found) {
                tempuser = x.next();
                temppass = x.next();

                if (tempuser.trim().equals(username.trim()) && temppass.trim().equals(password.trim())) {
                    found = true;
                    System.out.println("Welcome!");
                    account_screen_admin();
                }
            }
            x.close();

        }catch(Exception e){
            Incorrect();
        }

    }
    public static void Incorrect() {
        System.out.println("repeat 3 times done");
    }

    public static void account_screen_admin () {

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
                    case 1 -> list_users();
                    case 2 -> manage_users();
                    case 12 -> Menu.menu_display();
                    default -> System.out.println("Invalid input! Try again: ");
                }
            }
        }

        //displays menu
        public static void menu() {
            System.out.println("\n");
            System.out.println("\nAdmin Console");
            System.out.println("--------------------");
            System.out.println("Select an option:");
            System.out.println("1: List users");
            System.out.println("2: Manage users");
            System.out.println("12: Go back");

            System.out.println("Enter an Option");
        }

        public static void list_users() {
        System.out.println("List of users below: ");
        }

        public static void manage_users () {
        System.out.println("Manage users below: ");
        }
    }


