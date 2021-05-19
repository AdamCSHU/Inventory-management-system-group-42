public class currentuser {
    private static String thisuser = getthisuser();
    private static String thisbook = getbook();

    public static String getthisuser() {
        return thisuser;

    }

    public static void setthisuser(String username) {
        thisuser = username;


    }


    public static String getbook(){
    return thisbook;
    }

    public static void setbook(String book){
    thisbook = book;
    }
}

