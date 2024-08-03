// CategoryController.java
package controller;

import service.CategoryService;
import java.util.List;
import model.Category;
 import java.util.Scanner;
 
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void addCategory(String username) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter category name: ");
        String name = scanner.nextLine();
        Category category = new Category(name, username);
        categoryService.addCategory(category);
        System.out.println("Category added successfully!");
    }

    public void viewCategories(String username) {
        List<Category> categories = categoryService.getCategoriesByUser(username);
        for (Category category : categories) {
            System.out.println(category); // This should call the overridden toString() method
        }
    }

    public void deleteCategory(String username) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter category name to delete: ");
        String name = scanner.nextLine();
        categoryService.deleteCategory(name, username);
        System.out.println("Category deleted successfully!");
    }
}

