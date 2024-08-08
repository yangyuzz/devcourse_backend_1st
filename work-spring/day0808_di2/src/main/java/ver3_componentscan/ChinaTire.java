package ver3_componentscan;

import org.springframework.stereotype.Component;

//@Component
public class ChinaTire implements Tire {
    @Override
    public String getModel() { // insert
        return "대륙"; // oracle insert
    }
}
