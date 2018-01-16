package DataBindingExample.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/1/16 0016.
 */

@Controller
public class DataBindingController {
    private static final Log logger = LogFactory.getLog(DataBindingController.class);

    @RequestMapping(value="/pathVariableTest/{userId}")
    public void pathVariableTest(@PathVariable Integer userId) {

    }
}
