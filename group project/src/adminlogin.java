import java.io.File;
import java.util.Scanner;

public class adminlogin {


    // coded by Jack
        private static Scanner x;


        public static void admlogin() {

            Scanner in = new Scanner(System.in);

            System.out.println("Email: ");
            String username = in.next();
            System.out.println("Password; ");
            String password = in.next();
            String filepath = "admin.txt";

            admloginverify(username, password, filepath);
        }


        public static void admloginverify (String username, String password, String filepath) {
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
                        currentuser.setthisuser(username);
                        adminmenu.admmenu();

                    }
                    else {
                        System.out.println("Incorrect username or password");
                    }
                }

                x.close();

            }catch(Exception e){
                System.out.println("error");
            }

        }

    }

