package test03;





import java.util.Arrays;
import java.util.Comparator;

public class Test03 {
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

        Arrays.sort(students, new Comparator<Student>() { // 무명 클래스. implements Comparator 한 클래스. 1회용 클래스
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for(Student student : students){
            System.out.println(student);
        }
        System.out.println("------------------------------------");
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        for(Student student : students){
            System.out.println(student);
        }
    }
}

class Student {
    private String name;
    private int age;
    private int score;

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

