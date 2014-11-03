package mytests.thymeleafexamples.spring_thyme;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * by Irina.Petrovskaya on 11/3/2014.
 */

public class Person {
    public Person(String address, int age, String name) {
        this.address = address;
        this.age = age;
        this.name = name;
    }

    String name;
    int age;
    String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
