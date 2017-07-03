package requestMappingExample;

import entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by Administrator on 2017/6/22 0022.
 */
@RequestMapping("/springmvc")
@Controller
public class RequestMappingExample {
    private static final String SUCCESS = "success";

    /**
     * 最基本的RequestMapping使用方式。
     *
     * @return
     * @RequestMapping 既可以修饰方法，也可以修饰类
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
     */

    /**
     * 使用method指定请求方式
     */
    @RequestMapping(value = "/testRequestMappingMethod", method = RequestMethod.GET)
    public String testMethodGet() {
        System.out.println("testMethod POST");
        return SUCCESS;
    }

    @RequestMapping(value = "/testRequestMappingMethod", method = RequestMethod.POST)
    public String testMethodPost() {
        System.out.println("testMethod POST");
        return SUCCESS;
    }

    /**
     * params指定请求参数，heads指定请求头
     * pararm1
     * !param1
     * param1!=value1
     * {"param1=value1", "param2"}
     */
    @RequestMapping(value = "/testParamsAndHeaders",
            params = {"username", "age!=10"},
            headers = {"Accept-Language=zh-CN"}
    )
    public String testParamsAndHeaders() {
        System.out.println("testParamsAndHeaders");
        return SUCCESS;
    }

    /**
     * @PathVariable 映射URL中绑定的占位符
     * 可以通过@PathVariable将URL中的占位符参数绑定到控制器处理方法的入参中。
     * URL中的{XXX}占位符可以通过@PathVariable("XXX")绑定到参数中去。
     * 用于REST风格。
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id) {
        System.out.println("testPathVariable: " + id);
        return SUCCESS;
    }

    /**
     * REST风格
     * GET/POST/PUT/DELETE对应对数据库的增删改查操作。
     * HiddenHttpMethodFilter过滤器将POST对应的DELETE和PUT请求转换为标准http方法。
     * HiddenHttpMethodFilter过滤器在web.xml中配置。
     * <p>
     * 1. 配置HiddenHttpMethodFilter过滤器。
     * 2. 发送PUT，DELETE请求时，携带一个name="_method"的隐藏域，值为"DELETE"或"PUT"。
     */
    @RequestMapping(value = "/testREST/{id}", method = RequestMethod.GET)
    public String testRESTGet(@PathVariable("id") Integer id) {
        System.out.println("test REST GET: " + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testREST", method = RequestMethod.POST)
    public String testRESTPost() {
        System.out.println("test REST POST");
        return SUCCESS;
    }

    @RequestMapping(value = "/testREST/{id}", method = RequestMethod.PUT)
    public String testRESTPut(@PathVariable("id") Integer id) {
        System.out.println("test REST PUT: " + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testREST/{id}", method = RequestMethod.DELETE)
    public String testRESTDelete(@PathVariable("id") Integer id) {
        System.out.println("test REST DELETE: " + id);
        return SUCCESS;
    }

    /**
     * @RequestParam 映射请求参数
     * value值即为请求参数的参数名。
     * 请求时未带参数，将因不匹配而抛出异常。
     * 需指定@RequestParam 的required属性，通过defaultValue指定默认值。
     */
    @RequestMapping(value = "/testRequestParam")
    public String testRequestParam(@RequestParam(value = "username") String un,
                                   @RequestParam(value = "age", required = false) Integer age) {
        System.out.println("username: " + un);
        System.out.println("age: " + age);
        return SUCCESS;
    }

    /**
     * @RequestHeader 映射请求头
     * 略。同@RequestParam。
     */

    /**
     * @CookieValue 映射一个cookie值，属性同 @RequestParam
     */
    @RequestMapping(value = "/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSSIONID") String sessionId) {
        System.out.println("tesetCookieValue: sessionId" + sessionId);
        return SUCCESS;
    }

    /**
     * 使用POJO对象绑定请求参数值
     * Spring MVC会按照请求参数名与POJO属性名进行自动匹配，自动为该对象填充属性值。
     * 支持级联属性。
     * 重要且常用。
     */
    @RequestMapping("/testPOJO")
    public String testPOJO(User user) {
        System.out.println(user);
        return SUCCESS;
    }

    /**
     * 使用servlet原生的API作为参数
     * HttpServletRequest
     * HttpServletResponse
     * HttpSession
     * java.security.Principal
     * Locale
     * InputStream
     * OutputStream
     * Reader
     * Writer
     */
    @RequestMapping("/testServletAPI")
    public void testServletAPI(HttpServletRequest request,
                               HttpServletResponse response,
                               Writer out) throws IOException {
        System.out.println(request);
        System.out.println(response);
        out.write("hello springmvc");
        //return SUCCESS;
    }
}
