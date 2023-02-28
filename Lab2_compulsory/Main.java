import java.lang.invoke.LambdaConversionException;

public class Main {
    public static void main(String[] args) {
        Location location_1 = new Location("Tecuci", LocationTypes.CITY, 150, 200);
        Location location_2 = new Location("OMV", LocationTypes.GAS_STATION, 200, 200);
        Road road_1_2 = new Road(RoadTypes.COUNTRY, 100, 80, location_1, location_2);
        System.out.println(location_1.toString());
        System.out.println(road_1_2.toString());
    }
}