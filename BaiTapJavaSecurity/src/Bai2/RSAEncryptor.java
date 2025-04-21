package Bai2;

import java.security.*;
import javax.crypto.Cipher;
import java.util.Base64;

public class RSAEncryptor implements Encryptable {
    private KeyPair keyPair;

    public RSAEncryptor() {
        try {
            KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
            gen.initialize(2048);
            keyPair = gen.generateKeyPair();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String encrypt(String input) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
            return Base64.getEncoder().encodeToString(cipher.doFinal(input.getBytes()));
        } catch (Exception e) {
            return "RSA Encrypt Error";
        }
    }

    @Override
    public String decrypt(String input) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
            return new String(cipher.doFinal(Base64.getDecoder().decode(input)));
        } catch (Exception e) {
            return "RSA Decrypt Error";
        }
    }
}

