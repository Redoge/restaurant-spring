package app.redoge.restaurant.service;

import app.redoge.restaurant.entity.Category;
import app.redoge.restaurant.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryDAO;

    public void save(Category category) {
        categoryDAO.save(category);
    }
    public List<Category> getAllCategories() {
        return categoryDAO.findAll();
    }

    public Category getCategoryByName(String categoryName) { return categoryDAO.findByName(categoryName); }

}
