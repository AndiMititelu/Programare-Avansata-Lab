import java.lang.Math;
enum RoadTypes {
    HIGHWAY, EXPRESS, COUNTRY
}

public class Road {
    private RoadTypes type;
    private double length;
    private int speed_limit;
    private Location l1;
    private Location l2;
    public Road(RoadTypes type, int length, int speed_limit, Location l1, Location l2) {
        this.type = type;
        this.length = length;
        if(speed_limit > 0)
            this.speed_limit = speed_limit;
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
        return speed_limit;
    }
    public void setType (RoadTypes type){
        this.type = type;
    }
    public void setLength ( int length){
        this.length = length;
    }
    public void setY ( int speed_limit){
        this.speed_limit = speed_limit;
    }
    @Override
    public String toString() {
        //format pentru 'double': %.2f
        return String.format("%s to %s (type: %s) -- speed_limit: %d km/h, distance: %.2f km",
                l1.getName(), l2.getName(), type.toString(), speed_limit, length);
    }


}
