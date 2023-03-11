import javax.management.relation.Relation;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Person implements Node, Comparable<Person> {
    private String name;
    private String birthdate;
    private Map<Node, String> relationships;
    public Person(String name, String birthdate) {
        this.name = name;
        this.birthdate = birthdate;
        this.relationships = new HashMap<>();
    }
    @Override
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    public void addRelationship(Node node, String relation) {
        this.relationships.put(node, relation);
        if(node instanceof Person) {
            if(!((Person) node).relationships.containsKey(this))
                ((Person) node).relationships.put(this, relation);
        }
    }
    public Map<Node, String> getRelationships() {
        return relationships;
    }

    @Override
    public int compareTo(Person other) {
        return name.compareTo(other.name);
    }
}
