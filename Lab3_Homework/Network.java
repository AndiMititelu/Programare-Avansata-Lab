import java.util.*;

public class Network {
    private List<Node> nodes;
    private Map<Node, String> relationships = new HashMap<>();
    public Network() {
        nodes = new ArrayList<>();
        relationships = new HashMap<>();
    }
    /*
    public List<Node> getNodes() {
        return nodes;
    }
    */
    public void addNode(Node node) {
        this.nodes.add(node);
    }
    public int getNodeImportance(Node node) {
        int importance = 0;
        for(Node other : nodes) {
            if (node instanceof Person && other instanceof Person){
                Map<Node, String> relationships = ((Person) node).getRelationships();
                if(relationships.containsKey(other))
                    importance++;
            }
            else if(node instanceof Company && other instanceof Person) {
                Map<Person, String> employees = ((Company) node).getEmployees();
                if(employees.containsKey(other))
                    importance++;
            }
            else if(node instanceof Person && other instanceof Company) {
                Map<Person, String> employees = ((Company) other).getEmployees();
                if(employees.containsKey(node))
                    importance++;
            }
        }
        return importance;
    }
    public List<Node> getNodesByImportance() {
        Collections.sort(nodes, (Node n1, Node n2) -> {return getNodeImportance(n2) - getNodeImportance(n1);});
        return nodes;
    }
    public Map<Node, String> getRelationships() {
        return relationships;
    }
}
