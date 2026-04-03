import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;

public class BikeRental {
    private boolean isRegisteredUser;
    private String emailAddress;
    private String location;
    private LocalDateTime tripStartTime;
    private String bikeID;
    private boolean locationValid;
    private ActiveRental activeRental;
    private LinkedList<ActiveRental> activeRentalsList = new LinkedList<>();
    private UserRegistration userRegistration = new UserRegistration();

    public void simulateApplicationInput() {
        System.out.println("This is the simulation of the e-bike rental process.");
        this.isRegisteredUser = false;
        this.emailAddress = "";
        this.location = "";

        System.out.println(" Simulating the analysis of the rental request.");
        this.bikeID = analyseRequest();
        if (!locationValid) {
            System.out.println("Invalid location. Please try again.");
            return;
        }
        System.out.println("Simulating e-bike reservation…");
        reserveBike(bikeID);

        System.out.println("Displaying the active rentals…");
        viewActiveRentals();

        System.out.println("Simulating the end of the trip…");
        removeTrip(bikeID);

        System.out.println(" Displaying the active rentals after trip end…");
        viewActiveRentals();
    }

    private String analyseRequest() {
        if (isRegisteredUser) {
            System.out.println("Welcome back, " + emailAddress + "!");
        } else {
            System.out.println("You're not our registered user. Please consider registering.");
            userRegistration.registration();
        }
        return validateLocation(this.location);
    }

    private String validateLocation(String location) {
        for (Bike bike : BikeDatabase.bikes) {
            if (location.equals(bike.getLocation()) && bike.isAvailable()) {
                System.out.println("A bike is available at the location you requested.");
                locationValid = true;
                return bike.getBikeID();
            }
        }
        System.out.println(": Sorry, no bikes are available at the location you\n" +
                "requested. Please try again later.");
        locationValid = false;
        return null;
    }

    private void reserveBike(String bikeID) {
        if (bikeID != null) {
            for (Bike bike : BikeDatabase.bikes) {
                if (bikeID.equals(bike.getBikeID())) {
                    this.tripStartTime = LocalDateTime.now();
                    bike.setAvailable(false);
                    bike.setLastUsedTime(this.tripStartTime);
                    System.out.println(": Reserving the bike with the (bikeID). Please following the on-screen instructions\n" +
                            "to locate the bike and start your pleasant journey.");
                    activeRental = new ActiveRental(bikeID, emailAddress);
                    activeRentalsList.add(activeRental);
                }
            }
        }
    }

    private void viewActiveRentals() {
        if (activeRentalsList.isEmpty()) {
            System.out.println("No active rentals at the moment.");
        } else {
            for (ActiveRental rental : activeRentalsList) {
                System.out.println(rental);
            }
        }
    }

    private void removeTrip(String bikeID) {
         Iterator<ActiveRental> iterator = activeRentalsList.iterator();
        while (iterator.hasNext()) {
            ActiveRental rental = iterator.next();
            if (rental.getBikeID().equals(bikeID)) {
                iterator.remove();
                break;
            }
        }
     for(Bike bike : BikeDatabase.bikes){
        if(bike.getBikeID().equals(bikeID)){
            bike.setAvailable(true);
            bike.setLastUsedTime(LocalDateTime.now());
            System.out.println(" Your trip has ended. Thank you for riding with us.");
            break;
        }
     }
    }

}

