import java.util.List;

public class RentalService {
    private final ActiveRental activeRental;
    private final BikeService bikeService;
    public static final double BASE_FARE = 3.0;

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
    public boolean endRental(String bikeId, String userId, RegisteredUsers user) {
        Bike bike = bikeService.findBikeById(bikeId);
        if (bikeService.releaseBike(bike)) {
            activeRental.removeRental(userId, bike);

            System.out.println("\n=== Trip Finished ===");
            System.out.println("User: " + user.getFullName());
            user.displayUserType();
            double finalPrice = user.calculateFare(BASE_FARE);
            System.out.print("Final Fare: €");
            System.out.printf("%.2f\n", finalPrice);
            System.out.println("---------------------------");
            return true;
        }
        return false;
    }

    public boolean cancelRental(String bikeId, String userId) {
        return endRental(bikeId, userId, null);
    }

    public List<Bike> trackActiveRentals(String userId) {
        return activeRental.getRentedBikes(userId);
    }
}