public class Main {
    public static void main(String[] args) {
        ERyder bike1 = new ERyder("001",     80, true, 1000,"ABCD","12345");
        bike1.printRideDetails(20);
        bike1.ride();

        ERyder bike2 = new ERyder("002",    60, false, 2000,"EFGH","67890");
        bike2.printRideDetails(30);
        bike2.ride();
    }
}
