package interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/5/4.
 */

public class FirstInterceptor implements HandlerInterceptor {

    /**
     *
     * 调用目标方法之前
     * 权限、日志、事务
     */
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("preHandle");
        return true;
    }

    /**
     *
     *  调用目标方法之后，调用试图渲染之前调用。
     *  修改修改请求域中属性或视图进行修改
     */
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    /**
     *
     * 渲染视图之后调用
     * 释放资源
     */
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
        System.out.println("afterCompletion");
    }
}
