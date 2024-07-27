package test01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket receiveSocket = new DatagramSocket(8888);
        System.out.println("UDP 서버 시작됨.");

        while(true){
            // packet은 저쪽에서 던지는 데이터 꾸러미(택배상자). receivePacket은 무인택배함이라고 상상하세요!
            DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
            System.out.println("데이터 수신 대기중...");
            receiveSocket.receive(receivePacket);  // 기다림.
            String receiveMsg = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("메세지 수신함>>"+receiveMsg);
        }
    }
}
