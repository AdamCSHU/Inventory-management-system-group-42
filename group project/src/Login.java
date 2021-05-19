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

    public static void user_screen() throws IOException {

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
                case 1 -> list_books();
                case 2 -> manage_users();
                case 3 -> searchloan();
                case 4 -> loanbooks.loans();
                case 0 -> Menu.menu_display();
                default -> System.out.println("Invalid input! Try again: ");
            }
        }
    }



    //displays menu


    //displays user menu
    public static void user_menu() {
        System.out.println("\n");
        System.out.println("\nUser console");
        System.out.println("--------------------");
        System.out.println("Select an option:");
        System.out.println("1: List books in stock");
        System.out.println("2: Manage account");
        System.out.println("3: View due books");
        System.out.println("4: loan book.... ");
        System.out.println("0: Go back");

        System.out.println("Enter an Option");
    }



    public static void manageuser(){




    }


    public static void list_books() {
        System.out.println("List of books below: ");
        String filepath = "books.txt";
        String tempfile = "blank2.txt";
        File oldfile = new File (filepath);
        File newfile = new File (tempfile);

        String currentline;
        String data[];

        try {
            FileWriter fw = new FileWriter(tempfile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);

            while ((currentline =  br.readLine()) != null)
            {
                data = currentline.split(",");
                {
                    System.out.println(currentline);
                }


            }
            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();



        }
        catch (IOException e)
        {

        }



        
    }

    public static void searchloan() throws IOException{
        System.out.println("you have selected to check your loans");
        String filepath = "Loans.txt";
        String username = currentuser.getthisuser();
        searchRecord(filepath, username,1,",");
    }


    public static void manage_users() throws IOException {
        System.out.println("you have selected view account");
        String username = currentuser.getthisuser();
        boolean found = false;
        String input = "";
        String filepath = "members.txt";
        searchRecord(filepath, username,1,",");




        user_menu();



    }


    public static void searchRecord(String filepath, String searchterm, int pos, String delim) throws IOException {
        int position = pos-1;
        String tempfile = "blank.txt";
        File oldfile = new File(filepath);
        File newfile = new File(tempfile);
        String currentline;
        String data[];
        String output;

        try {
            FileWriter fw = new FileWriter(tempfile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);

            while ((currentline =  br.readLine()) != null)
            {
                data = currentline.split(",");
                if ((data[position].equalsIgnoreCase(searchterm)))
                {
                    output = currentline;
                    System.out.println(output);
                }


            }
            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();



        }
        catch (IOException e)
        {

        }


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


