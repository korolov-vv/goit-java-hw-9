package Exercise2;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person's name: " + getName() + ", person's age: " + getAge();
    }
}
