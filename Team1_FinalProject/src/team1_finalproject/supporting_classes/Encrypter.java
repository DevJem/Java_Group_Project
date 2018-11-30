package team1_finalproject.supporting_classes;


/**
  *  @Course: SDEV 450 ~ Java Programming III - Enterprise Java
  *  @Author Name: Jeremy DeHay
  *  @Assignment Name: team1_finalproject.supporting_classes
  *  @Date: Nov 29, 2018
  *  @Subclass Encrypter Description: This code snippet was modified from:
  *     Joe. “Java Symmetric AES Encryption Decryption Using JCE.” Javapapers, 
  *         2 Nov. 2014, javapapers.com/java/java-symmetric-aes-encryption-decryption-using-jce/.
  */
//Imports
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.*;

//Begin Subclass Encrypter
public class Encrypter {
    private static Cipher cipher;
    private static KeyGenerator keyGenerator;
    private static SecretKey secretKey;
    
    public Encrypter() throws NoSuchAlgorithmException, NoSuchPaddingException {
        keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        secretKey = keyGenerator.generateKey();
        cipher = Cipher.getInstance("AES");
    }
    
    public static String encrypt(String plainText) throws Exception {
        byte[] plainTextByte = plainText.getBytes();
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedByte = cipher.doFinal(plainTextByte);
        Base64.Encoder encoder = Base64.getEncoder();
        String encryptedText = encoder.encodeToString(encryptedByte);
        return encryptedText;
    }

    public static String decrypt(String encryptedText) throws Exception {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] encryptedTextByte = decoder.decode(encryptedText);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
        String decryptedText = new String(decryptedByte);
        return decryptedText;
    }

} // End Subclass Encrypter

/*
 (                         *     
 )\ )                    (  `    
(()/(  (   (   (  (  (   )\))(   
 /(_)) )\  )\  )\ )\ )\ ((_)()\  
(_))_ ((_)((_)((_|(_|(_)(_()((_) 
 |   \| __\ \ / / | | __|  \/  | 
 | |) | _| \ V / || | _|| |\/| | 
 |___/|___| \_/ \__/|___|_|  |_| 
      https://is.gd/RGR0UQ                  
*/