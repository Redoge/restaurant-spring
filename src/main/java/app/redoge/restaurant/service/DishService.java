package app.redoge.restaurant.service;

import app.redoge.restaurant.entity.Category;
import app.redoge.restaurant.entity.Dish;
import app.redoge.restaurant.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishService {
    @Autowired
    private DishRepository dishDao;

    public void save(Dish dish) {
        dishDao.save(dish);
    }

    public List<Dish> getAllDishes() {
        return dishDao.findAll();
    }

    public List<Dish> getDishesByCategory(Long l) {
        return dishDao.findByCategories_id(l);
    }

    public Optional<Dish> getById(Long id) {
        return dishDao.findById(id);
    }
}
