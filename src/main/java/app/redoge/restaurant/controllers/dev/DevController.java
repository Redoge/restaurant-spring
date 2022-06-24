package app.redoge.restaurant.controllers.dev;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dev")
public class DevController {

    @GetMapping("")
    public String showDev(Model model) {
        model.addAttribute("version", "alpha-1");
        model.addAttribute("author", "Redoge");
        model.addAttribute("project_name", "Restaurant");
        return "dev/main";
    }

}
