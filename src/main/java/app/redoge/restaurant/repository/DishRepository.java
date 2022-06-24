package app.redoge.restaurant.repository;

import app.redoge.restaurant.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {
}
