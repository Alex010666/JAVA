    import java.util.ArrayList;
    import java.util.Iterator;
    import java.util.List;
    import java.util.Scanner;
    public class AdminPanel {
        private List<RegisteredUsers> registeredUsersList = new ArrayList<>();
        private Scanner scanner = new Scanner(System.in);

        public void userManagementOptions() {
            while (true) {
                System.out.println("\nWelcome to E-Ryder Administrator Panel.");
                System.out.println("What do you want to do?");
                System.out.println("1. Add New Users");
                System.out.println("2. View Registered Users");
                System.out.println("3. Remove Registered Users");
                System.out.println("4. Update Registered Users");
                System.out.println("5. EXIT");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1: addNewUsers();
                    break;
                    case 2: viewRegisteredUsers();
                    break;
                    case 3: removeRegisteredUsers();
                    break;
                    case 4: updateRegisteredUsers();
                    break;
                    case 5: System.out.println("Exiting program...");
                    return;
                    default: System.out.println("Invalid choice. Please try again.");
                }
            }
        }

        private void addNewUsers() {
            System.out.print("How many users would you like to add? ");
            int numUsers = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < numUsers; i++) {
                System.out.println("\n--- Adding User " + (i + 1) + " ---");
                System.out.print("Enter full name: ");
                String fullName = scanner.nextLine();
                System.out.print("Enter email address: ");
                String email = scanner.nextLine();
                System.out.print("Enter date of birth (YYYY-MM-DD): ");
                String dob = scanner.nextLine();
                System.out.print("Enter card number: ");
                String cardNum = scanner.nextLine();
                System.out.print("Enter card expiry date: ");
                String expiry = scanner.nextLine();
                System.out.print("Enter card provider: ");
                String provider = scanner.nextLine();
                System.out.print("Enter CVV: ");
                String cvv = scanner.nextLine();
                System.out.print("Enter user type: ");
                String userType = scanner.nextLine();

                String[] trips = new String[3];
                for (int j = 0; j < 3; j++) {
                    System.out.println("\n--- Trip " + (j + 1) + " ---");
                    System.out.print("Enter trip date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter source: ");
                    String source = scanner.nextLine();
                    System.out.print("Enter destination: ");
                    String dest = scanner.nextLine();
                    System.out.print("Enter fare (€): ");
                    String fare = scanner.nextLine();
                    System.out.print("Enter feedback (can be NULL): ");
                    String feedback = scanner.nextLine();

                    StringBuilder tripSb = new StringBuilder();
                    tripSb.append("Date: ").append(date)
                            .append(", Source: ").append(source)
                            .append(", Destination: ").append(dest)
                            .append(", Fare (€): ").append(fare)
                            .append(", Feedback: ").append(feedback);
                    trips[j] = tripSb.toString();
                }

                RegisteredUsers newUser = new RegisteredUsers(fullName, email, dob, cardNum, expiry, provider, cvv, userType, trips);
                registeredUsersList.add(newUser);
                System.out.println("User added successfully!");
            }
        }

        private void viewRegisteredUsers() {
            if (registeredUsersList.isEmpty()) {
                System.out.println("No registered users to display");
                return;
            }
            System.out.println("\n--- All Registered Users ---");
            for (RegisteredUsers user : registeredUsersList) {
                System.out.println(user);
            }
        }

        private void removeRegisteredUsers() {
            if (registeredUsersList.isEmpty()) {
                System.out.println("No registered users to remove");
                return;
            }
            System.out.print("Enter email address of user to remove: ");
            String email = scanner.nextLine();
            boolean found = false;

            Iterator<RegisteredUsers> iterator = registeredUsersList.iterator();
            while (iterator.hasNext()) {
                RegisteredUsers user = iterator.next();
                if (user.getEmailAddress().equals(email)) {
                    iterator.remove();
                    found = true;
                    System.out.println("User removed successfully!");
                }
            }
            if (!found) {
                System.out.println("No user found with this email address");
            }
        }

              private void updateRegisteredUsers() {
            if (registeredUsersList.isEmpty()) {
                System.out.println("No registered users to update");
                return;
            }
            System.out.print("Enter email address of user to update: ");
            String email = scanner.nextLine();
            RegisteredUsers targetUser = null;

            for (RegisteredUsers user : registeredUsersList) {
                if (user.getEmailAddress().equals(email)) {
                    targetUser = user;
                    break;
                }
            }
            if (targetUser == null) {
                System.out.println("No user found with this email address");
                return;
            }

            System.out.println("\n--- Update User Info (Press ENTER to keep old value) ---");
            System.out.print("Type new full name: ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) targetUser.setFullName(newName);

            System.out.print("Type new date of birth: ");
            String newDob = scanner.nextLine();
            if (!newDob.isEmpty()) targetUser.setDateOfBirth(newDob);

            System.out.print("Type new card number (enter '0' for no change): ");
            String newCard = scanner.nextLine();
            if (!newCard.equals("0")) targetUser.setCardNumber(newCard);

            System.out.print("Type new card expiry date: ");
            String newExpiry = scanner.nextLine();
            if (!newExpiry.isEmpty()) targetUser.setCardExpiryDate(newExpiry);

            System.out.print("Type new card provider: ");
            String newProvider = scanner.nextLine();
            if (!newProvider.isEmpty()) targetUser.setCardProvider(newProvider);

            System.out.print("Type new CVV: ");
            String newCvv = scanner.nextLine();
            if (!newCvv.isEmpty()) targetUser.setCvv(newCvv);

            System.out.print("Type new user type: ");
            String newType = scanner.nextLine();
            if (!newType.isEmpty()) targetUser.setUserType(newType);

            System.out.println("User updated successfully!");
        }
    }

