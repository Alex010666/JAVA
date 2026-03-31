import java.util.List;


public class BikeService {

    private BikeDatabase bikeDatabase;


    public BikeService(BikeDatabase bikeDatabase) {
        this.bikeDatabase = bikeDatabase;
    }



    public Bike findBikeById(String bikeId) {
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID().equals(bikeId)) {
                return bike;
            }
        }
        return null;
    }


    public boolean reserveBike(Bike bike) {
        if (bike == null || !bike.isAvailable()) {
            return false;
        }
        bike.setAvailable(false);
        return true;
    }


    public boolean releaseBike(Bike bike) {
        if (bike == null || bike.isAvailable()) {
            return false;
        }
        bike.setAvailable(true);
        return true;
    }

    public List<Bike> getAvailableBikesByLocation(String location) {

        return null;
    }
}