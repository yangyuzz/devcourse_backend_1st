package test02;

public class Student {
    private String name;
    private double grade;

    public Student(String name, double grade) throws Exception {
        if(grade <0){
            throw new YangyuException();
        }else if(grade < 3){
            throw new InterruptedException("학점이 너무 낮은데요...ㅠㅠ");
        }
        this.name = name;
        this.grade = grade;
    }
}
