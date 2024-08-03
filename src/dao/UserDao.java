package dao;

import model.User;

public interface UserDao {
    void addUser(User user);
    User getUserByUsername(String username);
}
