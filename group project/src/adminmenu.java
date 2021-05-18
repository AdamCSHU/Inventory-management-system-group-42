import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
//coded by jack.

public class adminmenu {
    public static void admmenu(){
        int menuselect = 0;
        Scanner scaninput = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("\nemployee console");
        System.out.println("--------------------");
        System.out.println("Select an option:");
        System.out.println("1: add employee");
        System.out.println("2: add new books");

        System.out.println("0: Logout");


        System.out.println("Enter an Option");

        if (scaninput.hasNextInt())
            menuselect = scaninput.nextInt();


        switch (menuselect) {

            case 1:
                System.out.println("you have selected add employee ");
                addemployee();

                admmenu();
                break;


            case 2:
                System.out.println("you have selected add new books");
                addbooks();

                admmenu();


        }


    }















    public static void addemployee() {

        String Password = "";
        Scanner in = new Scanner(System.in);

        System.out.println("Enter employee Email: ");
        String Email = in.nextLine();

        //System.out.println("Enter an Email: ");
        //String Email = in.nextLine();
        do {
            System.out.println("Password must be longer than 5 characters");
            System.out.println("Enter a Password: ");
            Password = in.nextLine();
        }
        while (Password.length() < 6);




        String filepath = "employees.txt";


        SaveDetails(Email, Password, filepath);

        //SaveDetails(Name, Email, Password, filepath, Age, Gender);
        //SaveDetails(Name, Password, filepath);
    }

    public static void valid() {
        System.out.println("Valid");
    }

    //The function below saves a a person's details. These details will be entered using the sign up form.

    public static void SaveDetails(String Email, String Password, String filepath) {

        Scanner in = new Scanner(System.in);

        Email = Email;

        //Email = Email;

        Password = Password;


        filepath = filepath;

        try {
            FileWriter save = new FileWriter(filepath, true);
            BufferedWriter save_bw = new BufferedWriter(save);
            PrintWriter save_pw = new PrintWriter(save_bw);

            save_pw.println(Email + "," + Password);
            save_pw.flush();
            save_pw.close();

            System.out.println("new employee registered registered, please sign in.");

        } catch (Exception E) {
            System.out.println("Not saved");
        }

    }

    public static void addbooks(){
        String author;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter book title ");
        String title = in.nextLine();

        System.out.println("Enter the author");
        author = in.nextLine();

        System.out.println("Enter the genre");
        String genre = in.nextLine();






        String filepath = "books.txt";


        SavebookDetails(title,author,genre,filepath);


    }




    public static void SavebookDetails(String title, String author,String genre, String filepath) {

        Scanner in = new Scanner(System.in);

        title = title;



        author = author;

        genre = genre;


        filepath = filepath;

        try {
            FileWriter save = new FileWriter(filepath, true);
            BufferedWriter save_bw = new BufferedWriter(save);
            PrintWriter save_pw = new PrintWriter(save_bw);

            save_pw.println(title + "," + author +"," + genre);
            save_pw.flush();
            save_pw.close();

            System.out.println("new book added");

        } catch (Exception E) {
            System.out.println("Not saved");
        }

    }

}
