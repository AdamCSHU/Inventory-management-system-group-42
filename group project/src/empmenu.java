import javax.swing.*;
import java.io.*;
import java.util.List;
import java.util.Scanner;
// coded by jack

public class empmenu {


    public static void empmenus() throws IOException {

        int menuselect = 0;
        Scanner scaninput = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("\nemployee console");
        System.out.println("--------------------");
        System.out.println("Select an option:");
        System.out.println("1: edit users");
        System.out.println("2: edit books");
        System.out.println("3: delete users");
        System.out.println("4: delete books");
        System.out.println("5: view account details ");
        System.out.println("6: remove loaned books");
        System.out.println("0: Logout");


        System.out.println("Enter an Option");

        if (scaninput.hasNextInt())
            menuselect = scaninput.nextInt();


        switch (menuselect) {

            case 1:
                System.out.println("you have selected edit users");
                System.out.println("enter the email of the user to edit");
                Scanner edituse = new Scanner(System.in);
                String editterm = edituse.nextLine();
                String filepath = "members.txt";


                Scanner x = new Scanner(System.in);
                System.out.println("enter the new email of the user to edit");
                String newemail = x.nextLine();

                System.out.println("enter the new password of the user to edit");
                String newpass = x.nextLine() ;

                System.out.println("enter the new name the user to edit");
                String newname = x.nextLine();

                System.out.println("enter the new phone number of the user to edit");
                String newnumber = x.nextLine();

                System.out.println("enter the new address of the user to edit");
                String newaddress = x.nextLine();

                System.out.println("enter the new date of birth of the user to edit");
                String newdob = x.nextLine();

                edituser(filepath, editterm,1,",", newemail,newpass,newname,newnumber,newaddress,newdob);


                empmenus();
                break;


            case 2:
                System.out.println("you have selected edit book");
                System.out.println("enter the title of the user to edit");
                Scanner edit = new Scanner(System.in);
                String edittitle = edit.nextLine();
                filepath = "books.txt";


                Scanner z = new Scanner(System.in);
                System.out.println("enter the new title of the book to edit");
                String title = z.nextLine();

                System.out.println("enter the new author of the book to edit");
                String author = z.nextLine() ;

                System.out.println("enter the new genre the book to edit");
                String genre = z.nextLine();



                editbook(filepath, edittitle,1,",", title,author,genre);


                empmenus();
                break;
                case 3:
                    System.out.println("you have selected delete user");

                    filepath = "members.txt";
                    System.out.println("enter the user you wish to delete......");
                    Scanner name = new Scanner(System.in);
                    String deleteterm = name.nextLine();
                    removeRecord(filepath, deleteterm,1,",");

                    deleteterm = "";
                    filepath = "";

                    empmenus();



                break ;

            case 4:
                System.out.println("you have selected delete books");

                filepath = "books.txt";
                System.out.println("enter the book you wish to delete......");
                 name = new Scanner(System.in);
                 deleteterm = name.nextLine();
                removeRecord(filepath, deleteterm,1,",");

                deleteterm = "";
                filepath = "";

                empmenus();
                break;


            case 5:
                System.out.println("you have selected view account");
                String username = currentuser.getthisuser();
                boolean found = false;
                String input = "";
                filepath = "employees.txt";
                searchRecord(filepath, username,1,",");




                empmenus();
                break;
            case 6:
                filepath = "Loans.txt";
                System.out.println("Enter the ID of the loan...");
                Scanner w = new Scanner(System.in);
                String delete = w.nextLine();
                removeRecord(filepath, delete, 5, ",");




                empmenus();
                break;

            case 0:

                break;


            default:
                System.out.println("oops something went wrong!");
        }
    }






    public static void removeRecord(String filepath, String removeterm, int pos, String delim){
        int position = pos-1;
        String tempfile = "temp.txt";
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
                if (!(data[position].equalsIgnoreCase(removeterm)))
                {
                    pw.println(currentline);
                }


            }
            System.out.println("record removed");
            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();

            boolean delete = oldfile.delete();
            File dump = new File(filepath);
            newfile.renameTo(dump);

        }
        catch (IOException e)
        {

        }

    }



    public static void searchRecord(String filepath, String searchterm, int pos, String delim) throws IOException {
        int position = pos-1;
        String tempfile = "blank.txt";
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
    public static void edituser(String filepath, String editterm, int pos, String delim, String nmail, String npass, String nname,String nnumber, String nadd,String ndob) throws IOException {
        int position = pos - 1;


        String tempfile = "temp2.txt";
        File oldfile = new File(filepath);
        File newfile = new File(tempfile);
        String currentline;
        String data[];
        String newemail = nmail;
        String newpass = npass;
        String newname = nname;
        String newnumber =nnumber;
        String newaddress = nadd;
        String newdob = ndob;




        try {
            FileWriter fw = new FileWriter(tempfile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);

            while ((currentline = br.readLine()) != null) {
                data = currentline.split(",");
                if (!(data[position].equalsIgnoreCase(editterm))) {
                    pw.println(currentline);
                }


            }
            pw.println(newemail + "," + newpass + "," + newname+ "," + newnumber + "," + newaddress + "," + newdob);

            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();

            boolean delete = oldfile.delete();
            File dump = new File(filepath);
            newfile.renameTo(dump);

        } catch (IOException e) {

        }
    }

    public static void editbook(String filepath, String editterm, int pos, String delim, String ntitle, String nautho, String ngenre) throws IOException {
        int position = pos - 1;


        String tempfile = "temp2.txt";
        File oldfile = new File(filepath);
        File newfile = new File(tempfile);
        String currentline;
        String data[];
        String newtitle = ntitle;
        String newauthor = nautho;
        String newgenre = ngenre;




        try {
            FileWriter fw = new FileWriter(tempfile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);

            while ((currentline = br.readLine()) != null) {
                data = currentline.split(",");
                if (!(data[position].equalsIgnoreCase(editterm))) {
                    pw.println(currentline);
                }


            }
            pw.println(newtitle + "," + newauthor + "," + newgenre);

            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();

            boolean delete = oldfile.delete();
            File dump = new File(filepath);
            newfile.renameTo(dump);

        } catch (IOException e) {

        }
    }

}

