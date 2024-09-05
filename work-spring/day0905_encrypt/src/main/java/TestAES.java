import javax.crypto.Cipher;

import javax.crypto.spec.SecretKeySpec;

//import org.apache.commons.codec.binary.Hex;

public class TestAES {


    private static String message = "동해물과 백두산이 마르고 닳도록z";

    public static void main(String[] args) throws Exception {

//		// 1. 128 비트 비밀키 생성
//		KeyGenerator kgen = KeyGenerator.getInstance("AES");
//		kgen.init(128);
//		SecretKey skey = kgen.generateKey();
//		// 2. 비밀 키를 이렇게 저장하여 사용하면 암호화/복호화가 편해진다.
//		sKeyString = Hex.encodeHexString(skey.getEncoded());

        byte[] sKey = new byte[16];
        String key = "12345678901234567890123456789012";
        sKey = key.getBytes();

        // 3. 암호화 수행
        SecretKeySpec skeySpec = new SecretKeySpec(sKey, "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(message.getBytes());
        System.out.println("Encrypted string: " + new String(encrypted));

        // 4. 복호화 수행
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] original = cipher.doFinal(encrypted);
        String originalString = new String(original);
        System.out.println("Original string: " + originalString);
    }

}