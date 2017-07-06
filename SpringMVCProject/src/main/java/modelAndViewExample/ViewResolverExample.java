package modelAndViewExample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/7/5 0005.
 */

@RequestMapping("/springmvc")
@Controller
public class ViewResolverExample {
    private static final String SUCCESS = "success";

    /**
     * 视图解析过程
     */
    @RequestMapping("/testViewAndViewResolver")
    public String testViewAndViewResolver() {
        System.out.println("testViewAndViewResolver");
        return SUCCESS;
    }

    /**
     * JSTL视图
     * 国际化 //TO-DO
     */

    /**
     * view-controller
     * 适用于直接响应转发的访问页面，而不需要通过handler方法。
     * 为保证其他映射正常工作，实际开发中还需要配置<mvc:annotation-driven>标签
     * // <mvc:annotation-driven> TO-DO
     */

    @RequestMapping("/testCustomedView")
    public String testCustomedView() {
        System.out.println("testCustomedView");
        return "customedView";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect() {
        System.out.println("testRedirect");
        return "redirect:/index.jsp";
    }
}
