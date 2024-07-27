package test03;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerMain {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999); // 데이터 송수신 용도가 아니라 연결 대기 소켓
        System.out.println("서버 연결 오기를 기다리는중 ...");
        Socket socket = serverSocket.accept(); // 여기서 클라이언트의 요청을 기다림.
        System.out.println("연결 들어옴!! 클라이언트와 소켓 확보!");

        Thread listen = new ListenThread(socket);
        Thread speak = new SpeakThread(socket);

        listen.start();
        speak.start();
    }
}
