package modelAndViewExample;

import entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * Created by Administrator on 2017/7/3 0003.
 */
// @SessionAttributes(value = {"user"}, types = {String.class})
@RequestMapping("/springmvc")
@Controller
public class ModelAndViewExample {
    private static final String SUCCESS = "success";

    /**
     * Ŀ�귽���ķ���ֵ������ModelAndView����
     * ���п��԰�����ͼ��ģ����Ϣ
     * <p>
     * model�����ݻᱻ���뵽request������С�
     * ModelAndViewͨ��Map���ʹ洢���ԡ�
     * ����ͼ�У�ͨ�� RequestScope.������ ��ʽ��ȡ����ֵ��
     *
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        String viewName = SUCCESS;
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject("time", new Date());
        return modelAndView;
    }

    /**
     * Ŀ�귽���������Map����(Model���ͻ�ModelMap����)����
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        System.out.println(map.getClass().getName());  // BindingAwareModelMap
        map.put("names", Arrays.asList("Tom", "Jerry", "Mike"));
        return SUCCESS;
    }

    /**
     * @SessionAttributes ֻ�ܸ�װ����ֻ��������
     * ���˿���ͨ��������ָ����Ҫ�ŵ�session�е�������(value����ֵ)
     * ������ͨ��ģ�����ԵĶ��������ƶ���Щģ��������Ҫ�ŵ�session��(types����ֵ)
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Map<String, Object> map) {
        // user������request�У�������session�С�
        // @SessionAttribute(������) �����Լ�����request��Ҳ����session�С�
        User user = new User("Tom", "123456", "tom@153.com", 15);
        map.put("user", user);
        map.put("school", "abc");
        return SUCCESS;
    }

    /* @ModelAttribute */
    /**
     * @ModelAttribute �����ڱ��ύ��ӳ�䵽POJO����ʱ��ֻ���ض�ĳЩ����и��£������򱣳ֲ��䡣
     * 1. ����hidden���͵�inputԪ���ṩ����Ҫ���µ���
     * 2. ����ǰ��ȡ������Ȼ������д��δ���µ�ֵ��
     *
     * @ModelAttribute �ṩ��������Ч���������ݿ��л�ȡ���󣬶�����newһ���¶���
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user){
        System.out.println(user);
        return SUCCESS;
    }

    /**
     * �� @ModelAttribute ��ǵķ���������ÿ��Ŀ�귽��ִ��֮ǰ��springmvc���á�
     *
     * 1. ִ��@ModelAttribute ע�����εķ����������ݿ���ȡ�����󣬰Ѷ�����뵽Map�С�
     * 2. SpringMVC��Map��ȡ�����󣬲��ѱ���������������ö���Ķ�Ӧ���ԡ�
     * 3. SpringMVC������������Ŀ�귽���Ĳ�����
     *
     * ע�⣺@ModelAttribute ���εķ����У�����Map�е�������Ӧ��Ŀ�귽��������͵ĵ�һ����ĸСд���ַ���һ�¡�
     * @ModelAttribute ���εķ����ķ�����û��Ӱ�졣
     *
     * // TO-DO ԭ�����
     * @param id
     * @param map
     */
    @ModelAttribute
    public void getUser(@RequestParam(value="id", required=false) Integer id,
                        Map<String,Object> map){
        if(id!=null){
            User user = new User(1,"Tom","123456", "Tom@163.com", 12);
            System.out.println("�����ݿ��л�ȡһ������:"+user);
            map.put("user",user);
        }
    }
}
