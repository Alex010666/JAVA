public class ERyder{
    private String bikeID;
    private int batteryLevel;
    private  boolean isAvailable;
    private double kmDriven;
    private double totalFare;
    private int totalUsageInMinutes;

    public static final String COMPANY_NAME ="ERyder";
    public static final double BASE_FARE = 1.0;
    public static final double PER_MINUTE_FARE = 0.5;

    private final String LINKED_ACCOUNT;
    private final String LINKED_PHONE_NUMBER;

    public ERyder(String bikeID, int batteryLevel, boolean isAvailable, double kmDriven,String linkedAccount,String linkedPhoneNumber,double totalFare,int totalUsageInMinutes) {
        this.bikeID = bikeID;
        this.batteryLevel = batteryLevel;
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
        this.LINKED_ACCOUNT = "ABCDEFGH";
        this.LINKED_PHONE_NUMBER = "123456789";
        this.totalFare = totalFare;
        this.totalUsageInMinutes = totalUsageInMinutes;
    }

    public ERyder(String bikeID, int batteryLevel, boolean isAvailable, double kmDriven,String linkedAccount,String linkedPhoneNumber) {
        this.batteryLevel = batteryLevel;
        this.bikeID = bikeID;
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
        this.LINKED_ACCOUNT = linkedAccount;
        this.LINKED_PHONE_NUMBER = linkedPhoneNumber;
    }

        public void printRideDetails(int totalUsageInMinutes){
        totalFare=calculateTotalFare(totalUsageInMinutes);
        System.out.println("Company Name: " + COMPANY_NAME);
        System.out.println("Bike ID: " + bikeID);
        System.out.println("Linked Account: " + LINKED_ACCOUNT);
        System.out.println("Linked Phone Number: " + LINKED_PHONE_NUMBER);
        System.out.println("Total Fare: " + totalFare);
        System.out.println("Total Usage In Minutes: " + totalUsageInMinutes);
    }

    private double calculateTotalFare(int totalUsageInMinutes){
        return BASE_FARE + PER_MINUTE_FARE * totalUsageInMinutes;
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

        public double getKmDriven () {
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
      public String getLinkedAccount(){
        return LINKED_ACCOUNT;
      }
      public String getLinkedPhoneNumber(){
        return LINKED_PHONE_NUMBER;
      }

      public void printBikeDetails(){
        System.out.println("Bike ID: " + bikeID);
        System.out.println("Battery Level: " + batteryLevel);
        System.out.println("Is Available: " + isAvailable);
        System.out.println("KM Driven: " + kmDriven);
      }
    }