import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author mrkhatami
 * 11.01.20
 **/

// Java program to calculate MD5 hash value
public class PassHash {
    public static String getMd5(String input)
    {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // Driver code
    public static void main(String args[]) throws NoSuchAlgorithmException {
        String s = "Myppass#~23";
        java.util.Scanner in = new java.util.Scanner(System.in);
        System.out.println("Enter password : \n");
        String input = in.next();
        if(getMd5(input).equals(getMd5(s)))
            System.out.println("User Logged in!");
        else
            System.err.println("User/Password Not Found!");

    }

}
