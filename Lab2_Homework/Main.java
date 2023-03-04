public class Main {
    public static void main(String[] args) {
        Problem problem = new Problem();
        //Locations
        City city1 = new City("Onesti", 150, 200, 50000);
        GasStation gas1 = new GasStation("OMV", 200, 200, 7.2);
        problem.setAllLocations(city1, gas1);
        Airport air1 = new Airport("Otopeni", 500, 400, 5);
        problem.addLocation(air1);
        Airport air2 = new Airport("Otopeni", 500, 400, 5);
        problem.addLocation(air2); //aici voi primi un mesaj de avertizare ca nu pot adauga 2 locatii identice

        //Roads
        Road roadCity1ToAir1 = new Road(RoadTypes.EXPRESS, 550, 100, air1, city1);
        problem.setAllRoads(roadCity1ToAir1);
        Road roadCity1ToGas1 = new Road(RoadTypes.COUNTRY, 50, 70, city1, gas1);
        problem.addRoad(roadCity1ToGas1);

        //Afisare
        for(Location l : problem.getAllLocations()){
            System.out.println(l.toString());
        }
        for(Road r : problem.getAllRoads()) {
            System.out.println(r.toString());
        }
        System.out.println("Is the problem valid? " + problem.isValid());

    }
}