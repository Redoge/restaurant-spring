package app.redoge.restaurant.controllers.manager;

import app.redoge.restaurant.entity.Category;
import app.redoge.restaurant.entity.Dish;
import app.redoge.restaurant.entity.OrderStatus;
import app.redoge.restaurant.entity.User;
import app.redoge.restaurant.repository.CategoryRepository;
import app.redoge.restaurant.service.CategoryService;
import app.redoge.restaurant.service.DishService;
import app.redoge.restaurant.service.ManagerService;
import app.redoge.restaurant.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/manager")
public class MainManagerController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private OrderStatusService orderStatusService;
    @Autowired
    private DishService dishService;
    @GetMapping("")
    public String showMainPage(){
        return "manager/main_manager";
    }
    @GetMapping("make-new-dish")
    public String showMakeNewDishPage(Model model, Dish dish){
        model.addAttribute("allCategories", categoryService.getAllCategories());
        return "manager/make_new_dish";
    }
    @PostMapping("make-new-dish")
    public String getMakeNewDishPage(Model model, @Valid Dish dish, BindingResult bindingResult){
        System.out.println(dish);
        if(bindingResult.hasErrors()){
            model.addAttribute("allCategories", categoryService.getAllCategories());
            return "manager/make_new_dish";
        }
        dishService.save(dish);
        model.addAttribute("allDish", dishService.getAllDishes());
        model.addAttribute("allCategories", categoryService.getAllCategories());
        return "manager/all_dish";
    }

    @GetMapping("all_dish")
    public String showAllDishPage(Model model, Category category, @RequestParam("category") Optional<Long> categoryId){
        System.out.println(categoryId);
        model.addAttribute("allDish", categoryId.isEmpty() ?  dishService.getAllDishes() : dishService.getDishesByCategory(categoryId.get()));
        model.addAttribute("allCategories", categoryService.getAllCategories());
        return "manager/all_dish";
    }

    @GetMapping("make-new-category")
    public String showMakeNewCategoryPage(Category category, Model model){
        model.addAttribute("categories", categoryService.getAllCategories());
        return "manager/make_new_category";
    }

    @PostMapping ("make-new-category")
    public String getMakeNewCategoryPage(@Valid Category category , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "manager/make_new_category";
        }
        categoryService.save(category);
        return "redirect:/manager/make-new-category";
    }

    @GetMapping("update_dish/{id}")
    public String showUpdateDishPage(@PathVariable("id") long id, Model model, Dish dish){
        model.addAttribute("someDish", dishService.getById(id).get());
        return "manager/update_dish";
    }
    @GetMapping("update_dish")
    public String showUpdateDishPage(){return "redirect:/manager/all_dish";}

    @PostMapping("update_dish/{id}")
    public String getUpdateDishPage(@PathVariable("id") long id, Model model, @Valid Dish dish,
                                    BindingResult bindingResult, @RequestParam Map<String, String> param){
        System.out.println("\nObject: " + dish);
        System.out.println("All param: " + param+"\n");
        model.addAttribute("someDish", dishService.getById(id).get());
        if(bindingResult.hasErrors()){
            return "manager/update_dish";
        }
        dishService.save(dish);
        return "redirect:/manager/all_dish";
    }
    @GetMapping("make-new-orderStatus")
    public String showMakeNewOrderStatusPage(OrderStatus orderStatus, Model model){
        model.addAttribute("statuses", orderStatusService.getAllOrderStatus());
        return "manager/make_new_order_status";
    }
    @PostMapping("make-new-orderStatus")
    public String getMakeNewOrderStatusPage(@Valid OrderStatus orderStatus, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "manager/make_new_order_status";
        }
        orderStatusService.save(orderStatus);
        return "redirect:/manager/make-new-orderStatus";
    }

}
