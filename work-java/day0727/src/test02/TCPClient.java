package test02;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        System.out.println("서버에게 연결을 시도할 거에요!");
        Socket socket = new Socket("127.0.0.1", 9999);
        System.out.println("오 서버가 제 요청을 받아줬어요!");

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 이제는 클라이언트도 서버의 이야기를 들어주자
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.print("보낼 메세지 입력 >> ");
            String msg = sc.nextLine(); // 키보드로 입력받은 메세지를 보내기
            bw.write(msg+"\n");
            bw.flush();

            msg = br.readLine();
            System.out.println("서버도 말하네요 : "+msg);
        }

    }
}
