import java.io.*;
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

        System.out.println("Enter a Name: ");
        String Name = in.nextLine();

        //System.out.println("Enter an Email: ");
        //String Email = in.nextLine();

        System.out.println("Enter a Password: ");
        String Password = in.nextLine();

        //System.out.println("Enter an Age: ");
        //String Age = in.nextLine();

        //System.out.println("Enter a Gender: ");
        //String Gender = in.nextLine();

        String filepath = "members.txt";

        //SaveDetails(Name, Email, Password, filepath, Age, Gender);
        SaveDetails(Name, Password, filepath);
    }


    //The function below saves a a person's details. These details will be entered using the sign up form.

    public static void SaveDetails(String Name, String Password, String filepath) {

        Scanner in = new Scanner(System.in);

        Name = Name;

        //Email = Email;

        Password = Password;

       // Age = Age;

        //Gender = Gender;

        filepath = filepath;

        try {
            FileWriter save = new FileWriter(filepath, true);
            BufferedWriter save_bw = new BufferedWriter(save);
            PrintWriter save_pw = new PrintWriter(save_bw);

            save_pw.println(Name + "," + Password + "" +
                    "");
            save_pw.flush();
            save_pw.close();

            System.out.println("You are now registered, please sign in.");

        } catch (Exception E) {
            System.out.println("Not saved");
        }

    }
}
