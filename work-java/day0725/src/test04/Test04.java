package test04;

import java.util.Arrays;
import java.util.Comparator;

public class Test04 {
    static int hahahaha=100;
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

        Arrays.sort(students,(o1, o2)->{
            int num = 100; // 람다도 하나의 메소드라서 안에서 필요한 변수 만들어 쓰는건 지장 없음.
            System.out.println("이름으로 정렬중!");
//            students = new Student[10]; // 정렬하는 도중에 잠깐잠깐 쓰는 부품함수 주제에 밖에 있는 데이터를 변경해???? 안돼애애애애애애애애
            hahahaha = 200; // 밖에 있는 지역변수는 건드리면 안됨.. 근데 클래스 멤버야 ? 그러면 객체안에 계속 유지되는 변수네? 그럼 건드릴 수 있음!
            return o1.getName().compareTo(o2.getName());
        });

        for(Student student : students){
            System.out.println(student);
        }
        System.out.println("------------------------------------");
        Arrays.sort(students, (o1, o2)->o2.getAge()-o1.getAge());

        for(Student student : students){
            System.out.println(student);
        }
        /**
         * 람다는 무명 클래스로 메소드 하나짜리 객체를 매번 정의해야 하는 상황에서 태어났음.
         * (매개변수)->{메소드 실행문} 이지만 
         * 매개변수가 하나이면 소괄호 생략가능
         * 메소드 실행문이 return 한문장이면 중괄호와 return 키워드 생략 가능
         */
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

