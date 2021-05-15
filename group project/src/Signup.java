import java.io.*;
import java.net.PasswordAuthentication;
import java.util.*;
import java.util.List;
import java.util.Scanner;

public class Signup {

    public static void main(String[] args) {

    }

    public static void SignUp() {
        System.out.println("Sign up using the form below");
        Sign_up();
    }

    //main function of the game class, it will allow the user to save game info to "database.csv"
    public static void Sign_up() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter your Email: ");
        String Email = in.nextLine();

        //System.out.println("Enter an Email: ");
        //String Email = in.nextLine();

        System.out.println("Password must be longer than 5 characters");
        System.out.println("Enter a Password: ");
        String Password = in.nextLine();

        System.out.println("Enter your full name: ");
        String Full_Name = in.nextLine();

        System.out.println("Enter your Phone Number: ");
        String Phone_Number = in.nextLine();

        System.out.println("Enter your Address: ");
        String Address = in.nextLine();

        System.out.println("Enter your date of birth: ");
        String DOB = in.nextLine();

        //System.out.println("Enter an Age: ");
        //String Age = in.nextLine();

        //System.out.println("Enter a Gender: ");
        //String Gender = in.nextLine();

        String filepath = "members.txt";

        if(Password.length() > 5) {
            System.out.println("Password is valid.");
            SaveDetails(Email, Password, Full_Name, Phone_Number, Address, DOB, filepath);
        }else{
            System.out.println("Password is too short, try again");
            Sign_up();
        }

        //SaveDetails(Name, Email, Password, filepath, Age, Gender);
        //SaveDetails(Name, Password, filepath);
    }

    public static void valid ()
    {
        System.out.println("Valid");
    }

    //The function below saves a a person's details. These details will be entered using the sign up form.

    public static void SaveDetails( String Email, String Password, String Full_Name, String Phone_Number, String Address, String DOB, String filepath) {

        Scanner in = new Scanner(System.in);

        Email = Email;

        //Email = Email;

        Password = Password;

        Full_Name = Full_Name;

       // Age = Age;

        Phone_Number = Phone_Number;

        //Gender = Gender;

        Address = Address;

        DOB = DOB;

        filepath = filepath;

        try {
            FileWriter save = new FileWriter(filepath, true);
            BufferedWriter save_bw = new BufferedWriter(save);
            PrintWriter save_pw = new PrintWriter(save_bw);

            save_pw.println(Email + "," + Password + "," + Full_Name + "," + Phone_Number + "," + Address + "," + DOB +
                    "");
            save_pw.flush();
            save_pw.close();

            System.out.println("You are now registered, please sign in.");

        } catch (Exception E) {
            System.out.println("Not saved");
        }

    }
}
