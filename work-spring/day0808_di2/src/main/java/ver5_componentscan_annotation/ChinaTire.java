package ver5_componentscan_annotation;


import org.springframework.stereotype.Repository;

@Repository // db작업 객체인가보당
public class ChinaTire implements Tire {
    @Override
    public String getModel() { // insert
        return "대륙"; // oracle insert
    }
}
