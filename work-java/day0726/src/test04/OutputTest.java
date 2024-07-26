package test04;

import java.io.*;

public class OutputTest {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("ttttt2")));

        bw.write("이 메세지가 편하게 파일로 전달됩니다. 전송 효율도 보장되지요");
        bw.flush();
        bw.close();
    }
}
