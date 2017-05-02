package requestMappingTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/4/29.
 */

@RequestMapping("/springmvc")
@Controller
public class RequestMappingTest {
    private static final String SUCCESS = "success";

    @RequestMapping(value = "testParamsAndHeaders", params = {"userename", "age!=10"})
    public String testParamsAndHeaders() {
        System.out.println("testParamsAndHeaders");
        return SUCCESS;
    }

    // @PathVariable REST风格

    // @RequestParam 绑定请求参数

    // @RequestHeader

    // @CookieValue

    // POJO参数

    // Servlet原生API作为参数

}
