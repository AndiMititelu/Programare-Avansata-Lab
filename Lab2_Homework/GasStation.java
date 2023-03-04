import java.util.Objects;

/**
 * Represents a gas station in the "Best Route Problem".
 */
public class GasStation extends Location {

    private double gasPrice;
    public GasStation(String name, int x, int y, double gas_price) {
        super(name, x, y);
        if(gasPrice > 0)
            this.gasPrice = gas_price;
        else
            System.out.println("Gas price cant be negative!");
    }
    public double getGas_price() {
        return gasPrice;
    }

    public void setGas_price(double gas_price) {
        if(gas_price > 0)
            this.gasPrice = gas_price;
        else
            System.out.println("Gas price cant be negative!");
    }

    @Override
    public String toString() {
        //format pentru 'double': %.2f
        return String.format("Location: %s (type: Gas Station) -- Coordinates(x, y): %d, %d -- Gas price: %.2f lei" ,
                getName(), getX(), getY(), gasPrice);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) //daca comparam obj cu el insusi => true
            return true;
        if(!(obj instanceof GasStation))
            return false;
        GasStation l1 = (GasStation) obj;
        return (Objects.equals(l1.getName(), getName()) && l1.getX() == getX() && l1.getY() == getY() && l1.gasPrice == gasPrice);
    }

}
