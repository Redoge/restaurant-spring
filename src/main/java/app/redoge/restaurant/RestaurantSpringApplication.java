package app.redoge.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication
public class RestaurantSpringApplication {
    public static void main(String[] args) {

        SpringApplication.run(RestaurantSpringApplication.class, args);
    }

}
