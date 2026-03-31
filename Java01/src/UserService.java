import java.util.List;
import java.util.Iterator;
public class UserService {
    private final List<RegisteredUsers> registeredUsersList;


    public UserService(List<RegisteredUsers> registeredUsersList) {
        this.registeredUsersList = registeredUsersList;
    }


    public void addUser(RegisteredUsers newUser) {
        registeredUsersList.add(newUser);
    }


    public List<RegisteredUsers> getAllUsers() {
        return registeredUsersList;
    }


    public boolean removeUser(String email) {
        boolean found = false;
        Iterator<RegisteredUsers> iterator = registeredUsersList.iterator();
        while (iterator.hasNext()) {
            RegisteredUsers user = iterator.next();
            if (user.getEmailAddress().equals(email)) {
                iterator.remove();
                found = true;
            }
        }
        return found;
    }

    public RegisteredUsers findUserByEmail(String email) {
        for (RegisteredUsers user : registeredUsersList) {
            if (user.getEmailAddress().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public void updateUser(RegisteredUsers targetUser, String newName, String newDob,
                           String newCard, String newExpiry, String newProvider,
                           String newCvv, String newType) {
        if (!newName.isEmpty()) targetUser.setFullName(newName);
        if (!newDob.isEmpty()) targetUser.setDateOfBirth(newDob);
        if (!newCard.equals("0") && !newCard.isEmpty()) targetUser.setCardNumber(newCard);
        if (!newExpiry.isEmpty()) targetUser.setCardExpiryDate(newExpiry);
        if (!newProvider.isEmpty()) targetUser.setCardProvider(newProvider);
        if (!newCvv.isEmpty()) targetUser.setCvv(newCvv);
        if (!newType.isEmpty()) targetUser.setUserType(newType);
    }

    public boolean isUserListEmpty() {
        return registeredUsersList.isEmpty();
    }
}
