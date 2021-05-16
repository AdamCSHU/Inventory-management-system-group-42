import java.io.File;
import java.io.IOException;
import java.util.Scanner;
// coded by jack

public class empmenu {


    public static void empmenus() {

        int menuselect = 0;
        Scanner scaninput = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("\nemployee console");
        System.out.println("--------------------");
        System.out.println("Select an option:");
        System.out.println("1: edit users");
        System.out.println("2: edit books");
        System.out.println("3: view account details ");
        System.out.println("0: Logout");


        System.out.println("Enter an Option");

        if (scaninput.hasNextInt())
            menuselect = scaninput.nextInt();


        switch (menuselect) {

            case 1:
                System.out.println("you have selected edit users");


                empmenus();
                break;


            case 2:
                System.out.println("you have selected edit books");
                empmenus();

                break;


            case 3:
                System.out.println("you have selected view account");
                String username =  currentuser.getthisuser();
                boolean found = false;
                String input = "";
                String filepath = "employees.txt";


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

                empmenus();
                break;

            case 0:

                break;


            default: System.out.println("oops something went wrong!");
        }


    }




    private void search(String title, String filepath) {

        boolean found = false;
        String input = "";


        try {
            Scanner read = new Scanner(new File(filepath));
            read.useDelimiter("[,\n]");
            while ((read.hasNext() && found) == false) {
                input = read.next();
                if (input.equals((title))) {
                    System.out.println(input + read.nextLine());
                    found = true;

                    break;
                }
                System.out.println("not found");
                break;


            }
        } catch (IOException e) {

        }
    }

}

