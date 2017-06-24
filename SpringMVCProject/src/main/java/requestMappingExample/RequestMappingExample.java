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
     * �������RequestMappingʹ�÷�ʽ��
     * @RequestMapping �ȿ������η�����Ҳ����������
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
     * 1. value������URL
     * 2. method�����󷽷�
     * 3. params���������
     * 4. heads������ͷ
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
