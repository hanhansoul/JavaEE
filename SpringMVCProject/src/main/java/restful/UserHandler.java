package restful;

import dao.DepartmentDao;
import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import po.User;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/1.
 */

@Controller
public class UserHandler {

    @Autowired
    private UserDao userDao;

    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Map<String, Object> map) {
        for (User user : userDao.getAll()) {
            System.out.println(user.getId());
        }
        map.put("users", userDao.getAll());
        return "list";
    }

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public String input(Map<String, Object> map) {
        System.out.println("add user");
        map.put("departments", departmentDao.getDepartments());
        map.put("user", new User());
        return "input";
    }

    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String save(User user) {
        System.out.println("save");
        userDao.save(user);
        return "redirect:/emps";
    }

    // @PathVariable
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        userDao.deleteUser(id);
        return "redirect:/emps";
    }

//    @RequestMapping(value = "/test", method = RequestMethod.DELETE)
//    public String test() {
//        // userDao.deleteUser(id);
//        System.out.println("success");
//        return "redirect:/success";
//    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id, Map<String, Object> map) {
        map.put("user", userDao.getUser(id));
        map.put("departments", departmentDao.getDepartments());
        return "input";
    }

    //    @ModelAttribute
    @ModelAttribute
    public void getUser(@RequestParam(value = "id", required = false) Integer id,
                        Map<String, Object> map) {
        if (id != null) {
            map.put("user", userDao.getUser(id));
        }
    }

    @RequestMapping(value = "/emp", method = RequestMethod.PUT)
    public String update(User user) {
        userDao.save(user);
        return "redirect:/emps";
    }


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
}
