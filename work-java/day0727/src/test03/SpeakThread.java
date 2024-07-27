package test03;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class SpeakThread extends Thread {
    private BufferedWriter bw;

    public SpeakThread(Socket socket) {
        try {
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            System.out.println("Speak 생성자 예외");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                System.out.print("보낼 메세지 입력 >> ");
                String line = sc.nextLine();
                bw.write(line + "\n");
                bw.flush();
            }
        } catch (IOException e) {
            System.out.println("SpeakThread가 더이상 메세지를 보낼 수 없습니다.");
        }
    }
}
