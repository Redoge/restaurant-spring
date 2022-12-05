package app.redoge.restaurant.controllers.client;

import app.redoge.restaurant.entity.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class MainClientController {
    @GetMapping("")
    public String showMain() {
        return "client/main_client";
    }

    @GetMapping("my-orders")
    public String showMyOrders() {
        return "client/my_orders";
    }

    @GetMapping("make-order")
    public String showMakeNewOrder(Order order, Model model) {
        return "client/make_new_order";
    }

}
