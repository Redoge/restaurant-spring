package app.redoge.restaurant.entity;

import app.redoge.restaurant.repository.CategoryRepository;
import app.redoge.restaurant.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 2, max =20, message = "Name should be between 3 and 20 characters")
    private String name;

    @Positive(message = "Price must be 1 and more")
    private double price;


    @ManyToOne
    @JoinColumn(name = "categories_id")
    @NotNull
    private Category categories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategories() {
        return categories;
    }

    public void setCategories(Category categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", categories=" + (categories==null?null:categories.getName()) +
                '}';
    }
}
