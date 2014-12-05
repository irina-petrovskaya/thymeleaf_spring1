package mytests.thymeleafexamples.spring_thyme.web.conversion;

import mytests.thymeleafexamples.spring_thyme.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by irina on 9/24/2014.
 */
public class PersonFormatter implements Formatter<Person> {
    @Autowired
    MessageSource messageSource;

    @Override
    public String print(Person person, Locale locale) {
        String name = person.getName();
        System.out.println("person.getName() = " + name);
        if ((name == null) || (name.equals(""))){ name="default";}
        return name.toUpperCase(locale);
    }

    @Override
    public Person parse(String s, Locale locale) throws ParseException {
        return new Person(s,0,"");
    }
}
