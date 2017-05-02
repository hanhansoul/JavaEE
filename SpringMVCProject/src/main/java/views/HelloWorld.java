package views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/4/29.
 */

@Controller
public class HelloWorld {

    @RequestMapping("/hello")
    private String hello() {
        System.out.println("Hello World!");
        return "success";
    }
}
