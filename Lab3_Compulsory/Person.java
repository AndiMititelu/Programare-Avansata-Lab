import java.util.ArrayList;
import java.util.Comparator;

public class Person implements Node, Comparable<Person> {
    private String name;
    public Person(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int compareTo(Person other) {
        return name.compareTo(other.name);
    }
}
