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
     * HttpMessageConverter<T>����������Ϣת��Ϊһ������(����ΪT)���򽫶���(����ΪT)���Ϊ��Ӧ��Ϣ��
     * HttpInputMessage ==> HttpMessageConverter == ... ==> HttpMessageConverter ==> HttpOutputMessage
     * Spring MVC Ĭ��װ��������HttpMessageConverter��
     *
     *
     * ʹ��MessageConverter��������Ϣת�����󶨵�������������л���Ӧ���תΪ��Ӧ���͵���Ӧ��Ϣ��
     * �ṩ�����ַ���
     * 1. @RequestBody/@ResponseBody�Դ��������б�ע
     * 2. HttpEntity<T>/ResponseEntity<T>��Ϊ����������λ򷵻�ֵ
     * Spring���ȸ�������ͷ����Ӧͷ��Accept����ѡ��ƥ���HttpMessageConverter���������߲������ͻ��͹�ϵ���˵õ�
     * ƥ���HttpMessageConverter��
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/testJson")
    public Collection<User> testJson() {
        return userDao.getAll();
    }

    //    @ResponseBody�ɺ������ص�������Ϊѡ��HttpMessageConverter���͵ı�׼
    //    @RequestBody�ɺ���������������Ϊѡ��HttpMessageConverter���͵ı�׼
    //    HttpEntity<T>��ResponseEntity<T>ͬ������ ����

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
