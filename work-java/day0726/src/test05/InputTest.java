package test05;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class InputTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.yangyu"));

        Student s = (Student) ois.readObject();
        System.out.println(s);
    }
}
