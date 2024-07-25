package test03;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
//        JFrame jf = new JFrame();
//
//        jf.setSize(200, 300);
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jf.setVisible(true);
        new YangyuFrame();
    }
}

class YangyuFrame extends JFrame {

    public YangyuFrame() {
        super.add(new JButton("눌러보세용"));
        super.setSize(500,600);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setVisible(true);
    }
}
