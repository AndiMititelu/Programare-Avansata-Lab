enum LocationTypes {
    CITY, AIRPORT, GAS_STATION, MALL
}
public class Location {
    private String name;
    private LocationTypes type;
    private int x;
    private int y;
    public Location(String name, LocationTypes type, int x, int y) {
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
    }
    public String getName() {
        return name;
    }
    public LocationTypes getType() {
        return type;
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
    public void setType(LocationTypes type) {
        this.type = type;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        //format pentru 'double': %.2f
        return String.format("Location: %s (type: %s) -- Coordinates(x, y): %d, %d" ,
                name, type.toString(), x, y);
    }
}
