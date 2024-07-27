package test03;

import java.io.IOException;
import java.net.Socket;

public class TCPClientMain {
    public static void main(String[] args) throws IOException {
        System.out.println("서버에게 연결을 시도할 거에요!");
        Socket socket = new Socket("59.27.84.200", 9999);
        System.out.println("오 서버가 제 요청을 받아줬어요!");

        Thread listen = new ListenThread(socket);
        Thread speak = new SpeakThread(socket);

        listen.start();
        speak.start();
    }
}
