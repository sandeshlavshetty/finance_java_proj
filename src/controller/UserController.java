package controller;

import service.UserService;
import java.util.Scanner;

public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        userService.registerUser(username, password, name, email);
        System.out.println("Registration successful!");
    }

    public boolean login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        boolean loggedIn = userService.loginUser(username, password);
        if (loggedIn) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials!");
        }
        return loggedIn;
    }
}
