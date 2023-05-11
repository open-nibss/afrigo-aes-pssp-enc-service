package com.example.aespsspcrypto.utility;


import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Author: Mobolaji Ake
 * Property of Nigeria Interbank Settlement Systems
 * Use for AES AfriGO Encyption as a Service
 */

public class Encrypt {

    public static void main(String[] args) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
      // For in code Test
    }

    public static String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = Integer.toHexString(bts[i] & 0xFF);
            if (tmp.length() == 1) {
                des = des + "0";
            }
            des = des + tmp;
        }
        return des;
    }

    private static final byte[] IV = new byte[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    private static String Algorithm = "AES";

    private static String AlgorithmProvider = "AES/CBC/PKCS5Padding";

    public static String encrypt(String src, byte[] key) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
        SecretKey secretKey = new SecretKeySpec(key, Algorithm);
        IvParameterSpec ivParameterSpec = getIv(key,IV);
        System.out.println("IV === "+ivParameterSpec.getIV().toString());
        Cipher cipher = Cipher.getInstance(AlgorithmProvider);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
        byte[] cipherBytes = cipher.doFinal(src.getBytes(Charset.forName("utf-8")));
        return byte2Base64(cipherBytes);
    }

    public static IvParameterSpec getIv(byte[] keys, byte[] iv) throws UnsupportedEncodingException {
        byte[] tmpIv = new byte[iv.length];
        int i;
        for(i = 0; i < iv.length && i < keys.length; ++i) {
            tmpIv[i] = (byte)(iv[i] ^ keys[i]);
        }
        while(i < iv.length) {
            tmpIv[i] = iv[i];
            ++i;
        }
        IvParameterSpec ivParameterSpec = new IvParameterSpec(tmpIv);
        return ivParameterSpec;
    }

    public static String byte2Base64(byte[] bytes){
        Base64.Encoder base64decoder = Base64.getEncoder();
        return base64decoder.encodeToString(bytes);
    }

}
