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
    public String test4Mapping( @ModelAttribute Person person, BindingResult bindingResult){
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
        mav.addObject("first_person",personList.get(0));
        return mav;
    }

    /** non-public mapping **/

    @RequestMapping("/test5")
    String test5Mapping(ModelMap model) {
        List<Person> new_persons = new ArrayList<>();
        List<String> checkins = new ArrayList<>();
        checkins.add("in time ");
        //checkins.add("late");
        new_persons.add(new Person("sergey", 37,"Munich"));
        new_persons.add(new Person("yann", 38, "Brussel"));
        Boolean flag = true;
        model.addAttribute("isAdmin",flag);
        model.addAttribute("users", new_persons);
        model.addAttribute("new_persons", new_persons);
        model.addAttribute("checkins", checkins);
        return "test5_page";
    }

    /** test fragments specifying with viewbeans **/

    @RequestMapping("/test6")
    public String test6_fr1_Mapping(ModelMap model){

        return "test6_page";
    }
    @RequestMapping("/test6/fr1")
    public String test6Mapping(ModelMap model){
        model.addAttribute("test61","fragment fr1");
        return "test6_fr1_bean";
    }
    @RequestMapping("/test6/fr2")
    public String test6_fr2_Mapping(ModelMap model){
        model.addAttribute("test62","fragment fr2");
        return "test6_fr2_bean";
    }

    /** test fragments specifying in controller return value: **/

    @RequestMapping("/test6/fr3")
    public String test6_fr3_Mapping(ModelMap model){
        model.addAttribute("test63","fragment fr3");
        return "test6_page :: fr3 (arg1='myargument')";
    }
    @RequestMapping("/test6/fr4")
    public String test6_fr4_Mapping(ModelMap model){
        model.addAttribute("test64","fragment fr4");
        return "test6_page :: #fr4";
    }
}
