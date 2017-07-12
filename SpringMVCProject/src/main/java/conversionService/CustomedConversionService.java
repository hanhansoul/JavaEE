package conversionService;

import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import po.User;

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

}
