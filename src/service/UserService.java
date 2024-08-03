package service;

import dao.UserDao;
import model.User;

public class UserService {
    private UserDao userDao;
    private User currentUser;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void registerUser(String username, String password, String name, String email) {
        User user = new User(username, password, name, email);
        userDao.addUser(user);
    }

    public boolean loginUser(String username, String password) {
        User user = userDao.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            currentUser = user;
            return true;
        }
        return false;
    }

    public void logoutUser() {
        currentUser = null;
    }

    public String getCurrentUsername() {
        return currentUser != null ? currentUser.getUsername() : null;
    }
}
