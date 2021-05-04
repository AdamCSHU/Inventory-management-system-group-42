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
                }
            }
            x.close();

        }catch(Exception E){
            Incorrect();
        }

    }
    public static void Incorrect() {
        System.out.println("repeat 3 times done");
    }
}


