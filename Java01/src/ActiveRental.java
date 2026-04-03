import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActiveRental {
    private List<ActiveRental> activeRentalsList = new ArrayList<>();
    private String bikeID;
    private String userID;
    public ActiveRental(String bikeID, String userID) {
        this.bikeID = bikeID;
        this.userID = userID;
    }

    public void addRental(String userId, Bike bike) {
        ActiveRental newRental = new ActiveRental(bike.getBikeID(), userId);
        activeRentalsList.add(newRental);
    }

    public void removeRental(String userId, Bike bike) {
        activeRentalsList.removeIf(rental ->
                rental.getBikeID().equals(bike.getBikeID()) && rental.getUserID().equals(userId)
        );
    }

    public List<Bike> getRentedBikes(String userId) {
        List<Bike> rentedBikes = new ArrayList<>();
        for (ActiveRental rental : activeRentalsList) {
            if (rental.getUserID().equals(userId)) {
                for (Bike bike : BikeDatabase.bikes) {
                    if (bike.getBikeID().equals(rental.getBikeID())) {
                        rentedBikes.add(bike);
                        break;
                    }
                }
            }
        }
        return rentedBikes;
    }


    public String getBikeID() {
        return bikeID;
    }

    public void setBikeID(String bikeID) {
        this.bikeID = bikeID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    @Override
    public String toString() {
        return "ActiveRental{" +
                "bikeID='" + bikeID + '\'' +
                ", userID='" + userID + '\'' +
                '}';
    }
}

