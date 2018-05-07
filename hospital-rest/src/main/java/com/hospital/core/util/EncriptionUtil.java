package com.hospital.core.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class EncriptionUtil {

    public static String encrypt(String value, String algorithm) {
	MessageDigest digest = null;
	try {
	    digest = MessageDigest.getInstance(algorithm);
	} catch (NoSuchAlgorithmException e) {
	    e.printStackTrace();
	}
	byte[] hash = digest.digest(value.getBytes(StandardCharsets.UTF_8));
	return Base64.getEncoder().encodeToString(hash);
    }

    public static String encrypt(String value)  {
	return encrypt(value, "SHA-256");
    }

}
