import java.io.*;
import java.util.Scanner;


public class loanbooks {

    public static void loans() throws IOException {
        String filepath1 = "Loans.txt";
        String filepath2 = "books.txt";
        String booksearch;
        String username = currentuser.getthisuser();
        System.out.println("what book do you wish to loan out....");
        Scanner bchoice = new Scanner(System.in);
        booksearch = bchoice.next();
        getbookdetails(filepath2, booksearch,1,",");


        SaveDetails(username,currentuser.getbook(), filepath1);


    }
    public static void getbookdetails(String filepath, String searchterm, int pos, String delim) throws IOException {
        int position = pos - 1;


        String tempfile = "temp6.txt";

        String currentline;
        String data[];
        String book;




        try {
            FileWriter fw = new FileWriter(tempfile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);

            while ((currentline = br.readLine()) != null) {
                data = currentline.split(",");
                if ((data[position].equalsIgnoreCase(searchterm))) {
                    book = currentline;
                    currentuser.setbook(book);

                }


            }


            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();




        } catch (IOException e) {

        }
    }


    public static void SaveDetails( String user, String books, String filepath) {

        Scanner in = new Scanner(System.in);

        user = user;



        books = books;
        filepath = filepath;
        int ID = getRandomIntegerBetweenRange(1000,9999);


        try {
            FileWriter save = new FileWriter(filepath, true);
            BufferedWriter save_bw = new BufferedWriter(save);
            PrintWriter save_pw = new PrintWriter(save_bw);

            save_pw.println(user + "," + books + "," + ID);
            save_pw.flush();
            save_pw.close();

            System.out.println("you have loaned " + books);

        } catch (Exception E) {
            System.out.println("Not saved");
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
    public static int getRandomIntegerBetweenRange(int min, int max){
        int x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }
}