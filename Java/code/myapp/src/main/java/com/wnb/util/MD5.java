package com.wnb.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.google.common.primitives.Bytes;

public class MD5 {

    private static final char[] HEX = "0123456789abcdef".toCharArray();

    private static MessageDigest md5;

    static {
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String encode(String str) {
        try {
            return encode(str,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            // This could never happen.
            return "";
        }
    }
    
    public static String encode(String str,String charset) throws UnsupportedEncodingException {
        return Bytes.asList(md5.digest(str.getBytes(charset)))
                .stream()
                .collect(
                        StringBuilder::new,
                        (sb, b) -> sb
                                .append(HEX[(b.byteValue() & 0xf0) >>> 4])
                                .append(HEX[b.byteValue() & 0x0f]),
                        StringBuilder::append)
                .toString();
    }
}
