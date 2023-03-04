import java.util.Objects;

/**
 * Represents an airport in the "Best Route Problem".
 */
public class Airport extends Location {

    private int terminals;

    public Airport(String name, int x, int y, int terminals) {
        super(name, x, y);
        if(terminals > 0)
            this.terminals = terminals;
        else
            System.out.println("No of terminals cant be negative!");

    }

    public int getTerminals() {
        return terminals;
    }

    public void setTerminals(int terminals) {
        if(terminals > 0)
            this.terminals = terminals;
        else
            System.out.println("No of terminals cant be negative!");

    }

    @Override
    public String toString() {
        //format pentru 'double': %.2f
        return String.format("Location: %s (type: Airport) -- Coordinates(x, y): %d, %d -- No of terminals: %d" ,
                getName(), getX(), getY(), terminals);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) //daca comparam obj cu el insusi => true
            return true;
        if(!(obj instanceof Airport))
            return false;
        Airport l1 = (Airport) obj;
        return (Objects.equals(l1.getName(), getName()) && l1.getX() == getX() && l1.getY() == getY() && l1.terminals == terminals);
    }
}
