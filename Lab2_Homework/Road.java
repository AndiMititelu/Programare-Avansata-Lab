import java.lang.Math;
enum RoadTypes {
    HIGHWAY, EXPRESS, COUNTRY
}
/**
 * Represents a road in the "Best Route Problem".
 */
public class Road {
    private RoadTypes type;
    private double length;
    private int speedLimit;
    private Location l1;
    private Location l2;
    public Road(RoadTypes type, int length, int speed_limit, Location l1, Location l2) {
        this.type = type;
        this.length = length;
        if(speed_limit > 0)
            this.speedLimit = speed_limit;
        else
            System.out.println("Incorrect speed limit!!!");
        this.l1 = l1;
        this.l2 = l2;
        int x1 = l1.getX();
        int x2 = l2.getX();
        int y1 = l1.getY();
        int y2 = l2.getY();
        double distance;
        distance = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        if (length >= distance) {
            this.length = length;
        } else {
            System.out.println("Incorrect length!!!");
        }
    }
    public RoadTypes getType () {
        return type;
    }
    public double getLength () {
        return length;
    }
    public int getSpeed_limit () {
        return speedLimit;
    }
    public void setType (RoadTypes type){
        this.type = type;
    }
    public void setLength ( int length){
        this.length = length;
    }
    public void setY ( int speed_limit){
        this.speedLimit = speed_limit;
    }
    /**
     * Returns a string representation of the location.
     *
     * @return a string representation of the location
     */
    @Override
    public String toString() {
        //format pentru 'double': %.2f
        return String.format("Road %s to %s (road type: %s) -- Speed_limit: %d km/h, Distance: %.2f km",
                l1.getName(), l2.getName(), type.toString(), speedLimit, length);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) //daca comparam obj cu el insusi => true
            return true;
        if(!(obj instanceof Location))
            return false;
        Road r = (Road) obj;
        return (r.type == type && r.length == length && r.l1.equals(l1) && r.l2.equals(l2));
    }

}
