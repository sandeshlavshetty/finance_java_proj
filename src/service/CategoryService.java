
package service;

import dao.CategoryDao;
import model.Category;

import java.util.List;

public class CategoryService {
    private CategoryDao categoryDao;

    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public void addCategory(Category category) {
        categoryDao.addCategory(category);
    }

    public List<Category> getCategoriesByUser(String username) {
        return categoryDao.getCategoriesByUser(username);
    }

    public void deleteCategory(String name, String username) {
        categoryDao.deleteCategory(name, username);
    }
}
