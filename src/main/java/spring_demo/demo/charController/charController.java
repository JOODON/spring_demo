package spring_demo.demo.charController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class charController {
    @GetMapping("/chat")
    public String chatPage(){


        return "openChat";
    }
}
