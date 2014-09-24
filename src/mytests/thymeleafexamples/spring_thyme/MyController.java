package mytests.thymeleafexamples.spring_thyme;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by irina on 9/24/2014.
 */
@Controller
public class MyController {
    @ModelAttribute("str1_attr")
    public String str1(){
        return "my string 1";
    }
    @RequestMapping({"/test1"})
    public String test1Mapping(){
        return "test1_page";
    }
}
