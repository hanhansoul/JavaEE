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
     * 目标方法的返回值可以是ModelAndView类型
     * 其中可以包含视图和模型信息
     * <p>
     * model中数据会被放入到request域对象中。
     * ModelAndView通过Map类型存储属性。
     * 在视图中，通过 RequestScope.属性名 方式获取属性值。
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
     * 目标方法可以添加Map类型(Model类型或ModelMap类型)参数
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        System.out.println(map.getClass().getName());  // BindingAwareModelMap
        map.put("names", Arrays.asList("Tom", "Jerry", "Mike"));
        return SUCCESS;
    }

    /**
     * @SessionAttributes 只能该装饰器只能修饰类
     * 除了可以通过属性名指定需要放到session中的属性外(value属性值)
     * 还可以通过模型属性的对象类型制定哪些模型属性需要放到session中(types属性值)
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Map<String, Object> map) {
        // user被置于request中，而不在session中。
        // @SessionAttribute(属性名) 将属性既置于request中也置于session中。
        User user = new User("Tom", "123456", "tom@153.com", 15);
        map.put("user", user);
        map.put("school", "abc");
        return SUCCESS;
    }

    /* @ModelAttribute */
    /**
     * @ModelAttribute 用于在表单提交并映射到POJO对象时，只对特定某些域进行更新，其他域保持不变。
     * 1. 采用hidden类型的input元素提供不需要更新的域。
     * 2. 更新前获取副本，然后重新写入未更新的值。
     *
     * @ModelAttribute 提供了拦截器效果，从数据库中获取对象，而不是new一个新对象。
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user){
        System.out.println(user);
        return SUCCESS;
    }

    /**
     * 有 @ModelAttribute 标记的方法，会在每个目标方法执行之前被springmvc调用。
     *
     * 1. 执行@ModelAttribute 注解修饰的方法：从数据库中取出对象，把对象放入到Map中。
     * 2. SpringMVC从Map中取出对象，并把表单的请求参数赋给该对象的对应属性。
     * 3. SpringMVC把上述对象传入目标方法的参数。
     *
     * 注意：@ModelAttribute 修饰的方法中，放入Map中的属性名应与目标方法入参类型的第一个字母小写的字符串一致。
     * @ModelAttribute 修饰的方法的方法名没有影响。
     *
     * // TO-DO 原理解析
     * @param id
     * @param map
     */
    @ModelAttribute
    public void getUser(@RequestParam(value="id", required=false) Integer id,
                        Map<String,Object> map){
        if(id!=null){
            User user = new User(1,"Tom","123456", "Tom@163.com", 12);
            System.out.println("从数据库中获取一个对象:"+user);
            map.put("user",user);
        }
    }
}
