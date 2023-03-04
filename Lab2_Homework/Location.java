import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a location in the "Best Route Problem".
 */
public class Location {
    private String name;
    private int x;
    private int y;
    private boolean visited;
    /**
     * Constructs a new location with the specified name, type, and coordinates.
     *
     * @param name the name of the location
     * @param x the x-coordinate of the location
     * @param y the y-coordinate of the location
     */
    public Location(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
        visited = false;
    }
    public String getName() {
        return name;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public boolean getVisited() {
        return visited;
    }
    public void setVisited(boolean visited) {
        this.visited = visited;
    }


   /*
    @Override
    public String toString() {
        //format pentru 'double': %.2f
        return String.format("Location: %s (type: %s) -- Coordinates(x, y): %d, %d" ,
                name, type.toString(), x, y);
    }

    //DONT allow adding the same location or road twice
    @Override
    public boolean equals(Object obj) {
        if(obj == this) //daca comparam obj cu el insusi => true
            return true;
        if(!(obj instanceof Location))
            return false;
        Location l1 = (Location) obj;
        return (Objects.equals(l1.name, name) && l1.type == type && l1.x == x && l1.y == y);
    }

    */

}
