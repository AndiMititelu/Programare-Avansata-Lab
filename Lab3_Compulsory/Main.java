import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("Bob");
        Person person2 = new Person("Ana");
        Company company1 = new Company("Smol Brain Inc.");
        Company company2 = new Company("Big Brain Inc.");

        List<Node> nodes = new ArrayList<Node>();
        nodes.add(person1);
        nodes.add(person2);
        nodes.add(company1);
        nodes.add(company2);
        for(Node n : nodes) {
            System.out.println(n.getName());
        }


    }
}