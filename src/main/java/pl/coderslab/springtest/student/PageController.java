package pl.coderslab.springtest.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {


    @GetMapping("/page")
    public String page() {
        return "page/index";
    }

    @GetMapping("/")
    public String home() {
        return "page/home";
    }


}
