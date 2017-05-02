package requestMappingTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/30.
 */

@RequestMapping("/springmvc")
@Controller
public class MapAndModelTest {
    private static final String SUCCESS = "success";

    @RequestMapping("/MapTest")
    public String mapTest(Map<String, Object> map) {
        map.put("names", Arrays.asList("Tom", "Jerry", "Jack"));
        return SUCCESS;
    }
}
