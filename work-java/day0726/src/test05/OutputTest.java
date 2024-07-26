package test05;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class OutputTest {
    public static void main(String[] args) throws IOException {
        Student s = new Student("그렙", 20);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.yangyu"));
        oos.writeObject(s);
        oos.close();
    }
}
