import java.time.LocalDateTime;
import java.util.*;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
public class BikeService {

    private BikeDatabase bikeDatabase;

    private Stack<ERyderLogs> logStack = new Stack<>();

    private Queue<BikeRequest> bikeRequestQueue = new ArrayDeque<>();


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

        addLog("RENT_SUCCESS", "Bike " + bike.getBikeID() + " reserved successfully");

        return true;
    }

    public boolean releaseBike(Bike bike) {
        if (bike == null || bike.isAvailable()) {
            return false;
        }
        bike.setAvailable(true);

        addLog("RELEASE_SUCCESS", "Bike " + bike.getBikeID() + " released");
        processNextRequest();

        return true;
    }

    public List<Bike> getAvailableBikesByLocation(String location) {
        return null;
    }
    public void addRequestToQueue (String userEmail, String location){
            BikeRequest request = new BikeRequest(userEmail, location, LocalDateTime.now());
            bikeRequestQueue.add(request);
            System.out.println("[Queue] Request added: " + userEmail + " | " + location);
        }


        private void processNextRequest () {
            if (!bikeRequestQueue.isEmpty()) {
                BikeRequest request = bikeRequestQueue.poll();
                System.out.println("\n[Queue] Auto-assigning bike to:");
                System.out.println(request);

                addLog("QUEUE_PROCESSED", "Request processed for " + request.getUserEmail());
            }
        }

        private void addLog (String logId, String event){
            ERyderLogs log = new ERyderLogs(logId, event, LocalDateTime.now());
            logStack.push(log);
        }


        public void viewSystemLogs () {
            System.out.println("\n===== SYSTEM LOGS (STACK) =====");
            if (logStack.isEmpty()) {
                System.out.println("No logs yet.");
                return;
            }
            for (ERyderLogs log : logStack) {
                System.out.println(log);
            }
        }

        public void viewRequestQueue() {
            System.out.println("\n===== PENDING REQUESTS (QUEUE) =====");
            if (bikeRequestQueue.isEmpty()) {
                System.out.println("Queue is empty.");
                return;
            }
            for (BikeRequest req : bikeRequestQueue) {
                System.out.println(req);
            }
        }


        public void removeFirstRequest () {
            if (!bikeRequestQueue.isEmpty()) {
                bikeRequestQueue.poll();
                System.out.println("[Queue] First request removed.");
            } else {
                System.out.println("[Queue] Queue is empty.");
            }
        }


        public Stack<ERyderLogs> getLogStack () {
            return logStack;
        }

        public Queue<BikeRequest> getBikeRequestQueue () {
            return bikeRequestQueue;
        }
    }
