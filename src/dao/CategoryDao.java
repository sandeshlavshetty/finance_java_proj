package dao;

import model.Category;
import java.util.List;

public interface CategoryDao {
    void addCategory(Category category);
    List<Category> getCategoriesByUser(String username);
    void deleteCategory(String name, String username);
}

