package restful;

import dao.DepartmentDao;
import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import po.User;

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
    @RequestMapping(value = "/emp", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        userDao.deleteUser(id);
        return "redirect:/emps";
    }
}
