import java.io.*;
import java.util.*;

public class Login {

    private static Scanner x;

    public static void main(String[] args) {

    }

    public static void login() {
        Scanner in = new Scanner(System.in);

        System.out.println("Email: ");
        String username = in.next();
        System.out.println("Password; ");
        String password = in.next();
        String filepath = "members.txt";

        loginverify(username, password, filepath);
    }

    public static void loginverify (String username, String password, String filepath) {
        boolean found = false;
        String tempuser = "";
        String temppass = "";
        String adminusr = "admin";
        String adminpass = "password1";

        try {
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while(x.hasNext() && !found) {
                tempuser = x.next();
                temppass = x.next();

                if (tempuser.trim().equals(username.trim()) && temppass.trim().equals(password.trim())) {
                    found = true;
                    System.out.println("Welcome!");
                    currentuser.setthisuser(username);

                    user_screen();
                }
            }

            x.close();

        }catch(Exception e){
            Incorrect();
        }

    }
    public static void Incorrect() {
        System.out.println("Incorrect login, try again.");
    }

    public static void user_screen() {

        Scanner in = new Scanner(System.in);

        //creates menu input int
        int user_choice;

        //while loop keeps program running til valid option is selected
        while (true) {

            //calls menu function and displays it
            user_menu();

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
        System.out.println("12: Logout");

        System.out.println("Enter an Option");
    }

    //displays user menu
    public static void user_menu() {
        System.out.println("\n");
        System.out.println("\nUser console");
        System.out.println("--------------------");
        System.out.println("Select an option:");
        System.out.println("1: List books in stock");
        System.out.println("2: Mangage account");
        System.out.println("3: View due books");
        System.out.println("12: Go back");

        System.out.println("Enter an Option");
    }



    public static void manageuser(){




    }


    public static void list_users() {
        System.out.println("List of users below: ");
    }



    public static void manage_users() {
        String username =  currentuser.getthisuser();
        boolean found = false;
        String input = "";
        String filepath = "members.txt";


        try {
            Scanner read = new Scanner(new File(filepath));
            read.useDelimiter("[,\n]");
            while ((read.hasNext() && found) == false) {
                input = read.next();
                if (input.equals((username))) {
                    System.out.println(input + read.nextLine());
                    found = true;

                    break;
                }
                System.out.println("not found");
                break;


            }
        } catch (IOException e) {

        }

        Scanner in = new Scanner(System.in);

        System.out.println("Enter a search term: ");

        filepath = "members.txt";
        String searchterm = in.nextLine();

        read(searchterm, filepath);
    }

    private static Scanner test;

    public static void read (String searchterm, String filepath) {

        boolean foundterm = false;
        String username = ""; String password = "";

        try {
            test = new Scanner(new File(filepath));
            test.useDelimiter("[,\n]");

            while(test.hasNext() && !foundterm) {

                username = test.next();
                password = test.next();

                if (username.equals(searchterm)) {
                    foundterm = true;
                }
            }

            if (foundterm) {
                System.out.println("Found! " + username + "," + password);
            }else {
                System.out.println("Not found!");
            }

        }catch(Exception E) {
            System.out.println("Error!");
        }
    }

}


