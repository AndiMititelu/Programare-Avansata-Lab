import java.util.Objects;


/**
 * Represents a city in the "Best Route Problem".
 */
public class City extends Location {

    private int population;
    public City(String name, int x, int y, int population) {
        super(name, x, y);
        if(population > 0) {
            this.population = population;
        }
        else {
            System.out.println("Population cant be negative!");
        }

    }
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        if(population > 0)
            this.population = population;
        else
            System.out.println("Population cant be negative!");
    }

    @Override
    public String toString() {
        //format pentru 'double': %.2f
        return String.format("Location: %s (type: City) -- Coordinates(x, y): %d, %d -- Population: %d" ,
                getName(), getX(), getY(), population);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) //daca comparam obj cu el insusi => true
            return true;
        if(!(obj instanceof City))
            return false;
        City l1 = (City) obj;
        return (Objects.equals(l1.getName(), getName()) && l1.getX() == getX() && l1.getY() == getY() && l1.population == population);
    }
}
