package app.redoge.restaurant.controllers.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class MainClientController {
    @GetMapping("")
    public String showMain(){
        return "client/main_client";
    }

    @GetMapping("my-orders")
    public String showMyOrders(){
        return "client/my_orders";
    }
    @GetMapping("make-order")
    public String showMakeNewOrder(){ return "client/make_new_order";}

}
