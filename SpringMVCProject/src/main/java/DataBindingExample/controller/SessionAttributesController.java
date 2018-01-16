package DataBindingExample.controller;

import DataBindingExample.domain.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by Administrator on 2018/1/16 0016.
 */
@Controller
@SessionAttributes("user")
public class SessionAttributesController {

    private static final Log logger = LogFactory
            .getLog(SessionAttributesController.class);
    private String loginname;
    private String password;
    private Model model;

    // 该方法映射的请求为http://localhost:8080/DataBindingTest/{formName}
    @RequestMapping(value="/{formName}")
    public String loginForm(@PathVariable String formName){
        // 动态跳转页面
        return formName;
    }

    // 该方法映射的请求为http://localhost:8080/DataBindingTest/login
    @RequestMapping(value="/login")
    public String login(
            @RequestParam("loginname") String loginname,
            @RequestParam("password") String password,
            Model model ) {
        this.loginname = loginname;
        this.password = password;
        this.model = model;
        // 创建User对象，装载用户信息
        User user = new User();
        user.setLoginname(loginname);
        user.setPassword(password);
        user.setUsername("admin");
        // 将user对象添加到Model当中
        model.addAttribute("user",user);
        return "/welcome.jsp";
    }
}
