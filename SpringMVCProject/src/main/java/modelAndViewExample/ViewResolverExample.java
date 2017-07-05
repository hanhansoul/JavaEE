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
     * ��ͼ��������
     */
    @RequestMapping("/testViewAndViewResolver")
    public String testViewAndViewResolver() {
        System.out.println("testViewAndViewResolver");
        return SUCCESS;
    }

    /**
     * JSTL��ͼ
     * ���ʻ� //TO-DO
     */

    /**
     * view-controller
     * ������ֱ����Ӧת���ķ���ҳ�棬������Ҫͨ��handler������
     * Ϊ��֤����ӳ������������ʵ�ʿ����л���Ҫ����<mvc:annotation-driven>��ǩ
     * // <mvc:annotation-driven> TO-DO
     */
    
}
