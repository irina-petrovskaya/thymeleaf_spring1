package mytests.thymeleafexamples.spring_thyme;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * by Irina.Petrovskaya on 10/3/2014.
 */
@Component("componentBean1")
public class ComponentBean1 {
    @Value("componentBean1 property prop1")
    public String prop1;

    @Value("componentBean1 property prop2")
    String prop2;

    public String getProp2() {
        return prop2;
    }

    public void setProp2(String prop2) {
        this.prop2 = prop2;
    }
}
