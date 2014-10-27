package mytests.thymeleafexamples.spring_thyme;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * by Irina.Petrovskaya on 10/3/2014.
 */
@Component
public class ComponentBean1 {
    @Value("componentBean1 property prop1")
    public String prop1;
}
