package old.modelAndViewExample;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/6 0006.
 * 同理可以实现Excel自定义视图
 */
@Component
public class CustomedView implements View {
    public String getContentType() {
        return "text/html";
    }

    public void render(Map<String, ?> map,
                       HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.getWriter().print("hello view, time: " + new Date());
    }
}
