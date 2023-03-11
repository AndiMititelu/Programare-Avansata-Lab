import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Company implements Node, Comparable<Company>{
    private String name;
    private Map<Person, String> employees;
    public Company(String name) {
        this.name = name;
        employees = new HashMap<>();
    }
    public void addEmployee(Person person, String position) {
        employees.put(person, position);
    }
    public Map<Person, String> getEmployees() {
        return employees;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public int compareTo(Company other){
        return this.name.compareTo(other.name);
    }
    @Override
    public String toString() {
        return String.format("Company name: %s", getName());
    }
}
