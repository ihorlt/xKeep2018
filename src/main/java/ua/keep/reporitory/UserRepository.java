package ua.keep.reporitory;

import ua.keep.model.User;

public class UserRepository {
    public User[] getUsersAll() {
        User usr1 = new User(1L, "Igor", "igor@lyutak.com", "1122", 1);
        User usr2 = new User(2L, "Andriy", "andriy@gmail.com", "1133", 2);
        User[] userList = {usr1, usr2};
        return userList;
    }

}
