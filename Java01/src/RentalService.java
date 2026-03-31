import java.util.List;

public class RentalService {
    private final ActiveRental activeRental;
    private final BikeService bikeService;

    public RentalService(ActiveRental activeRental, BikeService bikeService) {
        this.activeRental = activeRental;
        this.bikeService = bikeService;
    }

    public boolean startRental(String bikeId, String userId) {
        Bike bike = bikeService.findBikeById(bikeId);
        if (bikeService.reserveBike(bike)) {
            activeRental.addRental(userId, bike);
            return true;
        }
        return false;
    }

    public boolean endRental(String bikeId, String userId) {
        Bike bike = bikeService.findBikeById(bikeId);
        if (bikeService.releaseBike(bike)) {
            activeRental.removeRental(userId, bike);
            return true;
        }
        return false;
    }

    public boolean cancelRental(String bikeId, String userId) {
        return endRental(bikeId, userId);
    }


    public List<Bike> trackActiveRentals(String userId) {
        return activeRental.getRentedBikes(userId);
    }
}