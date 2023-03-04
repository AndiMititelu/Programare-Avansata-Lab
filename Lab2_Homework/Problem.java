import java.util.Arrays;

/**
 * Represents an instance of the problem that contains roads and locations.
 */
public class Problem {
    Location[] allLocations;
    Road[] allRoads;
    /**
     * Sets one or more locations.
     *
     * @param locations the name of the location, where it is also checked for duplicates
     */
    public void setAllLocations(Location... locations) {
        Location[] auxLocations = new Location[locations.length];
        int index = 0;
        for(int i = 0; i < locations.length; i++) {
            boolean duplicate = false;
            //loop to compare previous items to check duplicate
            for(int j = 0; j < i; j++){
                if(locations[i].equals(locations[j])) {
                    duplicate = true;
                    break;
                }
            }
            if(!duplicate)
                auxLocations[index++] = locations[i];
        }

        int countNotNullElements = 0;
        for(Location loc : auxLocations) {
            if(loc != null)
                countNotNullElements++;
        }
        Location[] finalLocations = new Location[countNotNullElements];
        for(int i = 0; i < auxLocations.length; i++){
            if(auxLocations[i] != null)
                finalLocations[i] = auxLocations[i];
        }
        allLocations = finalLocations;
    }
    /**
     * Sets one or more roads.
     *
     * @param roads the name of the location, where it is also checked for duplicates
     */
    public void setAllRoads(Road... roads) {
        Road[] auxRoads = new Road[roads.length];
        int index = 0;
        for(int i = 0; i < roads.length; i++){
            boolean duplicate = false;
            for(int j = 0; j < i; j++) {
                if(roads[i].equals(roads[j])) {
                    duplicate = true;
                    break;
                }
            }
            if(!duplicate) {
                auxRoads[index++] = roads[i];
            }
        }
        int countNotNullElements = 0;
        for(Road r : auxRoads){
            if(r != null)
                countNotNullElements++;
        }
        Road[] finalRoads = new Road[countNotNullElements];
        for(int i = 0; i < auxRoads.length; i++) {
            if(auxRoads[i] != null)
                finalRoads[i] = auxRoads[i];
        }
        allRoads = finalRoads;
    }
    /**
     * It adds a new location to the all_locations array, only if the location was not added previously.
     */
    public void addLocation(Location location) {
        /*
            am creat un array de 'Location' auxiliar pentru a copia toate locatiile de pana acum
            verificam daca locatia pe care vrem sa o adaugam exista deja: daca nu add la aux_locations, else ne oprim
        */
        Location[] auxLocations = new Location[allLocations.length + 1];
        for(int i = 0; i < allLocations.length; i++) {
            if(allLocations[i].equals(location)){
                System.out.println("You cant add the same location!!!");
                return;
            }
            else
                auxLocations[i] = allLocations[i];
        }
        auxLocations[allLocations.length] = location; //add the new location at the end
        allLocations = auxLocations; //copy the final result
    }
    public void addRoad(Road road) {
        Road[] auxRoads = new Road[allRoads.length + 1];
        for(int i = 0; i < allRoads.length; i++) {
            if(allRoads[i].equals(road)) {
                System.out.println("You cant add the same road!");
                return;
            }
            else
                auxRoads[i] = allRoads[i];
        }
        auxRoads[allRoads.length] = road;
        allRoads = auxRoads;
    }
    /**
     * Returns an array with all the locations
     *
     * @return array with all the locations
     */
    public Location[] getAllLocations(){
        return allLocations;
    }
    /**
     * Returns an array with all the roads
     *
     * @return array with all the roads
     */
    public Road[] getAllRoads() {
        return allRoads;
    }
    public boolean isValid() {
        for(int i = 0; i < allLocations.length; i++) {
            for(int j = i+1; j < allLocations.length; j++) {
                if(allLocations[i].equals(allLocations[j]))
                    return false;
            }
        }
        for(int i = 0; i < allRoads.length; i++) {
            for(int j = i+1; j < allRoads.length; j++) {
                if(allRoads[i].equals(allRoads[j]))
                    return false;
            }
        }
        return true;
    }

}
