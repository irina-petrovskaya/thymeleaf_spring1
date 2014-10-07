package mytests.thymeleafexamples.spring_thyme;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by irina on 9/24/2014.
 */
@Controller
public class MyController {
    @ModelAttribute("common_str1_attr")
    public String str1(){
        return "my string 1";
    }
    @RequestMapping({"/test1"})
    public String test1Mapping(){
        return "test1_page";
    }
    @RequestMapping("/test2")
    public String test2Mapping(ModelMap model, HttpSession session){
        session.setAttribute("mysessionattribute1","mysessionattr_value");
        model.addAttribute("test2_model_attr1", "test2_attr1");
        return "test2_page";
    }
}
