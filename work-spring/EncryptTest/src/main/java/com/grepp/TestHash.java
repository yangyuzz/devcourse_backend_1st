package com.grepp;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TestHash {
	public static void main(String[] args) {
		String msg = "Hello";
		System.out.println("MD5 : " + testMD5(msg));
		System.out.println("SHA256 : " + testSHA256(msg));

		File file = new File("test.pdf");
		System.out.println(testHash(file, 32768));
	}

	// MD5
	public static String testMD5(String str) {
		String MD5 = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte byteData[] = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
						.substring(1));
			}
			MD5 = sb.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			MD5 = null;
		}
		return MD5;
	}

	// SHA-256
	public static String testSHA256(String str) {
		String SHA = "";
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-512");
			sh.update(str.getBytes());
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
						.substring(1));
			}
			SHA = sb.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			SHA = null;
		}
		return SHA;
	}

	public static String testHash(File file, int bufferSize) {
		String hash = null;
		try {
			byte[] buffer = new byte[bufferSize];
			BufferedInputStream in = new BufferedInputStream(
					new FileInputStream(file));
			MessageDigest digest = MessageDigest.getInstance("SHA-512");
			int sizeRead = -1;
			while ((sizeRead = in.read(buffer)) != -1) {
				digest.update(buffer, 0, sizeRead);
			}
			in.close();

			byte[] byteData = new byte[digest.getDigestLength()];
			byteData = digest.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
						.substring(1));
			}
			hash = sb.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return hash;
	}
}
