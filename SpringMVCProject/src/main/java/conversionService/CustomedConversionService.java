package conversionService;

import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import po.User;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/7/12 0012.
 */

@Controller
public class CustomedConversionService {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/testCustomedConversionService")
    public String testCostumedConversionService(@RequestParam("user") User user) {
        System.out.println("save user: ");
        userDao.save(user);
        return "success";
    }

    /**
     * HttpMessageConverter<T>负责将请求信息转换为一个对象(类型为T)，或将对象(类型为T)输出为响应信息。
     * HttpInputMessage ==> HttpMessageConverter == ... ==> HttpMessageConverter ==> HttpOutputMessage
     * Spring MVC 默认装配了六个HttpMessageConverter。
     *
     *
     * 使用MessageConverter将请求信息转化并绑定到处理方法的入参中或将响应结果转为对应类型的响应信息。
     * 提供了两种方法
     * 1. @RequestBody/@ResponseBody对处理方法进行标注
     * 2. HttpEntity<T>/ResponseEntity<T>作为处理方法的入参或返回值
     * Spring首先根据请求头或响应头的Accept属性选择匹配的HttpMessageConverter，进而更具参数类型或泛型关系过滤得到
     * 匹配的HttpMessageConverter。
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/testJson")
    public Collection<User> testJson() {
        return userDao.getAll();
    }

    //    @ResponseBody由函数返回的类型作为选择HttpMessageConverter类型的标准
    //    @RequestBody由函数参数的类型作为选择HttpMessageConverter类型的标准
    //    HttpEntity<T>和ResponseEntity<T>同理类似 ？？

    @ResponseBody
    @RequestMapping("/testHttpMessageConverter")
    public String testHttpMessageConverter(@RequestBody String body) {
        System.out.println(body);
        return "" + new Date();
    }

    @RequestMapping("/testResponseEntity")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        System.out.println("testResponseEntity");
        byte[] body = null;
        ServletContext servletContext = session.getServletContext();
        InputStream in = servletContext.getResourceAsStream("abc.txt");
        body = new byte[in.available()];
        in.read(body);

        HttpHeaders header = new HttpHeaders();
        header.add("Content-Disposition", "attachment;filename=abc.txt");
        HttpStatus statusCode = HttpStatus.OK;

        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body, header, statusCode);
        return response;
    }

}
