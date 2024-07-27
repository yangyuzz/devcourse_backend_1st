package test04;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChattingClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9999); //
        System.out.println("서버와 연결 성공!");

        new Listen(socket).start();
        new Speak(socket).start();
    }

    static class Listen extends Thread{
        BufferedReader br;
        Listen(Socket socket) throws IOException {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String receiveMsg = br.readLine();
                    System.out.println(receiveMsg);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    static class Speak extends Thread{
        BufferedWriter bw;
        Scanner sc;

        Speak(Socket socket) throws IOException {
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            sc = new Scanner(System.in);

            System.out.print("당신의 닉네임을 입력하세요:");
            String nickname = sc.nextLine();
            bw.write(nickname+"\n");
            bw.flush();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.print("me>>");
                    String sendMsg = sc.nextLine();
                    bw.write(sendMsg + "\n");
                    bw.flush();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
