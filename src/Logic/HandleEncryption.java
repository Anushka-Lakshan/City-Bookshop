/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;


import java.security.InvalidKeyException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
/**
 *
 * @author Anushka Lakshan
 */

public class HandleEncryption {

    private static final String ALGORITHM = "AES";
    private static final String KEY = "ILoveJavaProgram";

    public static String getEncryptedPass(String password) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(KEY.getBytes(), ALGORITHM));
            return Base64.getEncoder().encodeToString(cipher.doFinal(password.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getDecryptedPass(String encryptedPassword) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(KEY.getBytes(), ALGORITHM));
            return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedPassword)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
//    public static void main(String[] args) {
//        HandleEncryption handleEncryption = new HandleEncryption();
//        String encryptedPassword = handleEncryption.getEncryptedPass("Hi bro");
//        System.out.println(encryptedPassword);
//        
//        String decryptedPassword = handleEncryption.getDecryptedPass(encryptedPassword);
//        System.out.println(decryptedPassword);
//
//
//
//    }
}

