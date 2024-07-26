package test03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputTest {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("ttttt");

//        for (int i = 0; i < 10; i++) {
//            fos.write(i);
//        }
        String msg = "안녕하세요";
        byte[] bytes = msg.getBytes();

        for(byte b : bytes){
            fos.write(b);
        }

        fos.close();
    }
}
