package requestMappingExample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/6/22 0022.
 */
@RequestMapping("/springmvc")
@Controller
public class RequestMappingExample {
    private static final String SUCCESS = "success";

    /**
     * 最基本的RequestMapping使用方式。
     * @RequestMapping 既可以修饰方法，也可以修饰类
     *
     * @return
     */
    @RequestMapping("/testRequestMapping")
    public String testRequest() {
        System.out.println("testRequestMapping");
        return SUCCESS;
    }

    /**
     * @RequestMapping
     * 1. value：请求URL
     * 2. method：请求方法
     * 3. params：请求参数
     * 4. heads：请求头
     *
     */

    /**
     *
     * @return
     */
    @RequestMapping(value="/testMethod", method = RequestMethod.POST)
    public String testMethod(){
        System.out.println("testMethod");
        return SUCCESS;
    }

}
