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
     * �������RequestMappingʹ�÷�ʽ��
     *
     * @return
     * @RequestMapping �ȿ������η�����Ҳ����������
     */
    @RequestMapping("/testRequestMapping")
    public String testRequest() {
        System.out.println("testRequestMapping");
        return SUCCESS;
    }

    /**
     * @RequestMapping
     * 1. value������URL
     * 2. method�����󷽷�
     * 3. params���������
     * 4. heads������ͷ
     */

    /**
     * ʹ��methodָ������ʽ
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
     * paramsָ�����������headsָ������ͷ
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
     * @PathVariable ӳ��URL�а󶨵�ռλ��
     * ����ͨ��@PathVariable��URL�е�ռλ�������󶨵�������������������С�
     * URL�е�{XXX}ռλ������ͨ��@PathVariable("XXX")�󶨵�������ȥ��
     * ����REST���
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id) {
        System.out.println("testPathVariable: " + id);
        return SUCCESS;
    }

    /**
     * REST���
     * GET/POST/PUT/DELETE��Ӧ�����ݿ����ɾ�Ĳ������
     * HiddenHttpMethodFilter��������POST��Ӧ��DELETE��PUT����ת��Ϊ��׼http������
     * HiddenHttpMethodFilter��������web.xml�����á�
     * <p>
     * 1. ����HiddenHttpMethodFilter��������
     * 2. ����PUT��DELETE����ʱ��Я��һ��name="_method"��������ֵΪ"DELETE"��"PUT"��
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
     * @RequestParam ӳ���������
     * valueֵ��Ϊ��������Ĳ�������
     * ����ʱδ������������ƥ����׳��쳣��
     * ��ָ��@RequestParam ��required���ԣ�ͨ��defaultValueָ��Ĭ��ֵ��
     */
    @RequestMapping(value = "/testRequestParam")
    public String testRequestParam(@RequestParam(value = "username") String un,
                                   @RequestParam(value = "age", required = false) Integer age) {
        System.out.println("username: " + un);
        System.out.println("age: " + age);
        return SUCCESS;
    }

    /**
     * @RequestHeader ӳ������ͷ
     * �ԡ�ͬ@RequestParam��
     */

    /**
     * @CookieValue ӳ��һ��cookieֵ������ͬ @RequestParam
     */
    @RequestMapping(value = "/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSSIONID") String sessionId) {
        System.out.println("tesetCookieValue: sessionId" + sessionId);
        return SUCCESS;
    }

    /**
     * ʹ��POJO������������ֵ
     * Spring MVC�ᰴ�������������POJO�����������Զ�ƥ�䣬�Զ�Ϊ�ö����������ֵ��
     * ֧�ּ������ԡ�
     * ��Ҫ�ҳ��á�
     */
    @RequestMapping("/testPOJO")
    public String testPOJO(User user) {
        System.out.println(user);
        return SUCCESS;
    }

    /**
     * ʹ��servletԭ����API��Ϊ����
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
