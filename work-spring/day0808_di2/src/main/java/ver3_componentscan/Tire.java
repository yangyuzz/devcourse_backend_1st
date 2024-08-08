package ver3_componentscan;

// 자 DB작업 하는 애들은 이 표준을 다 갖춰야함.(insert, update, delete, selectOne, selectAll) 이라고 명시하면 이 인터페이스 구현하는 클래스는 필수로 이 메소드를 다 구현할 거임.
public interface Tire {
    String getModel();
}
