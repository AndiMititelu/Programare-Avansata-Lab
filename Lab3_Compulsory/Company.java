import java.util.ArrayList;

public class Company implements Node, Comparable<Company>{
    private String name;
    public Company(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public int compareTo(Company other){
        return this.name.compareTo(other.name);
    }
}
