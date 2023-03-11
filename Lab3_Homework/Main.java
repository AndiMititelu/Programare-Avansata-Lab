import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Network network = new Network();
        Person person1 = new Programmer("Bob", "14/10/2000", "C++");
        Person person2 = new Designer("Ana", "05/05/1995", "Website Design");
        Person person3 = new Programmer("Pedro", "01/01/1991", "Python");
        Person person4 = new Designer("Alex", "12/05/2002", "Product Design");
        Company company1 = new Company("Smol Brain Inc.");
        Company company2 = new Company("Big Brain Inc.");
        network.addNode(person1);
        network.addNode(person2);
        network.addNode(person3);
        network.addNode(person4);
        network.addNode(company1);
        network.addNode(company2);
        company1.addEmployee(person2, "Designer");
        company2.addEmployee(person4, "Designer");
        company2.addEmployee(person1, "Programmer");

        person2.addRelationship(person1, "friend");
        person2.addRelationship(company1, "employee");
        person1.addRelationship(company2, "employee");
        person4.addRelationship(company2, "employee");
        person3.addRelationship(person4, "friend");

        for(Node node : network.getNodesByImportance()) {
            System.out.println(node.getName() + ": " + network.getNodeImportance(node));
        }
    }
}