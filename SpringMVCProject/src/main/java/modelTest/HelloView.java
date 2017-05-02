package modelTest;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/30.
 */

/*
  自定义视图View
  org.springframework.web.servlet.view.BeanNameViewResolver
 */
@Component
public class HelloView implements View {
    public String getContentType() {
        return "text/html";
    }

    public void render(Map<String, ?> map,
                       HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.getWriter().print("hello modelTest.view, time: " + new Date());
    }
}
