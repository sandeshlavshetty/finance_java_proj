package dao;

import model.Category;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryCategoryDao implements CategoryDao {
    private List<Category> categories = new ArrayList<>();

    @Override
    public void addCategory(Category category) {
        categories.add(category);
    }

    @Override
    public List<Category> getCategoriesByUser(String username) {
        return categories.stream()
                .filter(category -> category.getUsername().equals(username))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCategory(String name, String username) {
        categories.removeIf(category -> category.getName().equals(name) && category.getUsername().equals(username));
    }
}
