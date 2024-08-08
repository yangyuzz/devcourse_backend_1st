package ver2_spring_xml;


public class KoreaTire implements Tire { // Tire 표준에 맞춰서 클래스 작성.(Tire가 구현하라는 거 다 구현은 해야지)

    @Override
    public String getModel() { // insert
        return "한국"; // mysql insert 구현함.
    }
}
