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

    // @PathVariable REST���

    // @RequestParam ���������

    // @RequestHeader

    // @CookieValue

    // POJO����

    // Servletԭ��API��Ϊ����

}
