package app.redoge.restaurant.controllers.manager;

import app.redoge.restaurant.entity.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/manager")
public class MainManagerController {

    @GetMapping("")
    public String showMainPage(){
        return "manager/main_manager";
    }
    @GetMapping("make-new-dish")
    public String showMakeNewDishPage(Model model){
        List<Category> categories =  new LinkedList<Category>();
        categories.add(new Category(1L, "Супи"));
        categories.add(new Category(2L, "Торти"));
        model.addAttribute("categories", categories);
        return "manager/make_new_dish";
    }
}
