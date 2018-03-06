package group.zzz.mvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestHandler {

    @RequestMapping("/test")
    public String test(){
        return "success";
    }
}
