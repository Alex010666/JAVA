public class ERyder{
    private String bikeID;
    private int batteryLevel;
    private  boolean isAvailable;
    private float kmDriven;

    public ERyder(String bikeID, int batteryLevel, boolean isAvailable, float kmDriven) {
        this.bikeID = bikeID;
        this.batteryLevel = batteryLevel;
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
    }
        public String getBikeID () {
            return bikeID;
        }
        public int getBatteryLevel () {
            return batteryLevel;
        }
        public boolean isAvailable () {
            return isAvailable;
        }

        public float getKmDriven () {
            return kmDriven;
        }
        public void setBatteryLevel ( int batteryLevel){
            if (batteryLevel >= 0 && batteryLevel <= 100) {
                this.batteryLevel = batteryLevel;
            } else {
                System.out.println("Error.");
            }
        }
      public void ride(){
        if(isAvailable&&batteryLevel>0){
            System.out.println("This bike is available.");
        }else {
            System.out.println("This bike is not available.");
        }
      }
      public void printBikeDetails(){
        System.out.println("Bike ID: " + bikeID);
        System.out.println("Battery Level: " + batteryLevel);
        System.out.println("Is Available: " + isAvailable);
        System.out.println("KM Driven: " + kmDriven);
      }
    }