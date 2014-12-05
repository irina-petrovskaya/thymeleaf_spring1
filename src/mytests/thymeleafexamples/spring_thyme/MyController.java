package mytests.thymeleafexamples.spring_thyme;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by irina on 9/24/2014.
 */
@Controller
public class MyController {

    private List<Person> personList = new ArrayList<Person>();

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

    @RequestMapping(value = "/test3")
    public String test4Mapping( Person person, BindingResult bindingResult){
     personList.add(person);
     return "test3_page";
    }

    @RequestMapping("/test4")
    public ModelAndView test3Mapping(){
        ModelAndView mav = new ModelAndView("test4_page");
        personList.add(new Person("irina", 44, "SPb"));
        personList.add(new Person("vera", 18, "SPb"));
        personList.add(new Person("andrey", 44, "SPb"));
        mav.addObject("persons", personList);
        return mav;
    }

    @RequestMapping("/test5")
    String test5Mapping(ModelMap model) {
        List<Person> new_persons = new ArrayList<>();
        new_persons.add(new Person("sergey", 37,"Munich"));
        new_persons.add(new Person("yann", 38, "Brussel"));

        model.addAttribute("new_persons", new_persons);

        return "test5_page";
    }
}
