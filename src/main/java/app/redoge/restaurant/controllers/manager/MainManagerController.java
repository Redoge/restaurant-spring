package app.redoge.restaurant.controllers.manager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class MainManagerController {

    @GetMapping("")
    public String showMain(){
        return "manager/main_manager";
    }

}
