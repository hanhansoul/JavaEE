package modelTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * Created by Administrator on 2017/4/30.
 */
@RequestMapping("/springmvc")
@Controller
public class ModelAndViewTest {

    @RequestMapping("/ModelAndViewTest")
    public ModelAndView modelAndViewTest() {
        String viewName = "success";
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject("time", new Date());
        return modelAndView;
    }

    @RequestMapping("/ViewAndViewResolver")
    public String testViewAndViewResolver() {
        System.out.println("testViewAndViewResolver");
        return "success";
    }

    @RequestMapping("/testView")
    public String testView() {
        System.out.println("viewTest");
        return "helloView";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect() {
        return "Redirect:/index0.jsp";
    }
}
