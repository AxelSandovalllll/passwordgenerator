package edu.guilford;

/**
 *
 * @author bousabacw
 */

//imports necessary to use AES
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

//class to encrypt and decrypt strings
public class AES {

    // secretKey is created using SecretKeySpec built in class
    private static SecretKeySpec secretKey;

    // an array is created that will store the key in order to make it harder to
    // access
    private static byte[] key;

    // sets the key
    public static void setKey(String myKey) {
        // MessageDigest is a built in class that will create a hash of the key
        MessageDigest sha = null;
        try {
            // converts the key to bytes
            key = myKey.getBytes("UTF-8");
            // creates a hash of the key
            sha = MessageDigest.getInstance("SHA-1");
            // stores the hash in the key array
            key = sha.digest(key);

            // sets a key length of 16
            key = Arrays.copyOf(key, 16);
            // creates a new secret key
            secretKey = new SecretKeySpec(key, "AES");

            // if there are any bugs/exceptions, this will catch them and return a null
            // statement
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    // encrpyt the string
    public static String encrypt(String strToEncrypt, String secret) {
        try {
            // sets the key
            setKey(secret);
            // creates a new cipher for encryption
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            // initializes the cipher for encryption
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            // returns the encrypted string
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        }
        // if there are any bugs/exceptions, this will catch them and return a null
        catch (Exception e) {
            // prints the error
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    // decrpyt the encrpyted string
    public static String decrypt(String strToDecrypt, String secret) {
        try {
            // sets the key
            setKey(secret);
            // creates a new cipher for decryption
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            // initializes the cipher for decryption
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            // returns the decrypted string
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        }
        // if there are any bugs/exceptions, this will catch them and return a null
        catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

}
