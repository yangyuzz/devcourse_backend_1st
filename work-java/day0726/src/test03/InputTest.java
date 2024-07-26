package test03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("ttttt");
//        int b;
//        while((b = fis.read()) != -1){
//            System.out.println(b);
//        }
        int b;
        byte[] buffer = new byte[30];
        int i=0;
        while((b = fis.read()) != -1){
            buffer[i++] =(byte) b;
        }
        System.out.println(new String(buffer));
        fis.close();
    }
}
