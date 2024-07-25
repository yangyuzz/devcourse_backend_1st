package test01;

import java.util.Arrays;
import java.util.Collections;

public class Test01 {
    public static void main(String[] args) {
        Student[] students = new Student[9];

        students[0] = new Student("조믿음", 25, 95);
        students[1] = new Student("이준호", 22, 85);
        students[2] = new Student("양유진", 20, 100);
        students[3] = new Student("조믿음", 25, 95);
        students[4] = new Student("이준호", 22, 85);
        students[5] = new Student("양유진", 20, 100);
        students[6] = new Student("이준호", 22, 85);
        students[7] = new Student("양유진", 20, 100);
        students[8] = new Student("조믿음", 25, 95);

        Arrays.sort(students);

//        System.out.println(students[0].compareTo(students[2]));
        for(Student student : students){
            System.out.println(student);
        }
    }

    static class Student implements Comparable<Student>{
        private String name;
        private int age;
        private int score;

        public Student(String name, int age, int score) {
            this.name = name;
            this.age = age;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            System.out.println("비교중!!");
            return this.age - o.age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", score=" + score +
                    '}';
        }
    }

}

