package test02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999); // 데이터 송수신 용도가 아니라 연결 대기 소켓
        System.out.println("서버 연결 오기를 기다리는중 ...");
        Socket socket = serverSocket.accept(); // 여기서 클라이언트의 요청을 기다림.
        System.out.println("연결 들어옴!! 클라이언트와 소켓 확보!");

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("서버는 계속 들어주기만 해요."+br.readLine());
            System.out.print("한번 들었으니 서버도 이제 말해요 >> ");
            String msg = sc.nextLine();
            bw.write(msg+"\n");
            bw.flush();
        }
    }
}
