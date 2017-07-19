package springIntegration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/7/19 0019.
 */

@Controller
public class HelloWorld {

    @Autowired
    private UserService userService;

    public HelloWorld() {
        System.out.println("helloworld constructor ...");
    }

    @RequestMapping("/helloworld")
    public String hello() {
        System.out.println("success");
        return "success";
    }
}
