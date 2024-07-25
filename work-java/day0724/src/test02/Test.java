package test02;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        Student[] students = new Student[50];

        try {
            students[0] = new Student("이준호", 4.5);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
