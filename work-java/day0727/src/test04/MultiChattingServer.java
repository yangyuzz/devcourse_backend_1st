package test04;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MultiChattingServer {
    private List<UserThread> userList; // 접속한 모든 사용자 담당 쓰레드를 여기 다 모아놓기
    private ServerSocket serverSocket; // 새로 접속하는 참여자가 있으면 이걸로 계속 받아서 족족 소켓을 생성해내야 함.

    public MultiChattingServer(){
        userList = new ArrayList<>();

        try {
            serverSocket = new ServerSocket(9999);
            while(true){ // 나는 소켓으로 메세지 주고받는건 신경 안쓰고 그냥 사용자를 계속 받아서 전체 관리만 함.
                System.out.println("클라이언트 대기중..");
                Socket socket = serverSocket.accept(); // 여기가 실행되면 클라이언트가 하나 또 접속한거임!
                System.out.println("접속 들어옴!:"+socket.getInetAddress());
                UserThread t = new UserThread(socket);
                userList.add(t);
                t.start();
            }
        } catch (IOException e) {
            System.out.println("프로그램이 종료됩니다. 서버 쥬금");
            throw new RuntimeException(e);
        }
    }

    synchronized public void broadcast(String msg){ // 현재 서버가 여러 쓰레드를 리스트로 유지중. 모든 쓰레드에게 speak하라고 명령하기
        for(UserThread user : userList){
            user.speak(msg);
        }
    }

    synchronized public void removeUser(UserThread user){
        userList.remove(user);
    }

    // 나는 중재자이고, 지금 접속한 한명의 사용자를 담당하는 하나의 쓰레드를 돌려놓는다.
    class UserThread extends Thread {
        private String nickname;
        private BufferedReader br;
        private BufferedWriter bw;

        public UserThread(Socket socket) {
            try {
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void run() { // start! 쓰레드 업무 시작!
            try {
                nickname = br.readLine(); // 일단 이 사용자 메세지 오기 전에 가장 첫 메세지를 닉네임으로 쓰자
                broadcast(nickname+"님이 입장하셨습니다.");
                while (true) { // 내가 담당하는 사용자의 메세지를 계속 듣고 있기
                    String msg = br.readLine();
                    broadcast("["+nickname+"]:"+msg);
                }
            } catch (IOException e) {
                removeUser(this); // 현재 내 객체를 이제 리스트에서 지워주세요. 라고 서버에게 부탁하기
                System.out.println(nickname+"사용자가 퇴장하셨습니다.");
            }
        }

        public void speak(String sendMsg){
            try {
                bw.write(sendMsg+"\n");
                bw.flush();
            } catch (IOException e) {
                removeUser(this); // 현재 내 객체를 이제 리스트에서 지워주세요. 라고 서버에게 부탁하기
                System.out.println(nickname+"님이 더이상 유효하지 않습니다. 메세지 못보냄.");
            }
        }
    }

    public static void main(String[] args) {
        MultiChattingServer server = new MultiChattingServer();
    }
}
