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
     * �÷����ڵ���Ŀ�귽��֮ǰ����
     * Ȩ�ޡ���־������
     * ������ֵΪtrue����������ú�������������Ŀ�귽����
     * ������ֵΪfalse���򲻻���ú�������������Ŀ�귽����
     *
     */
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("preHandle");
        return true;
    }

    /**
     *
     *  ����Ŀ�귽��֮�󣬵�����ͼ��Ⱦ֮ǰ���á�
     *  �޸��޸������������Ի���ͼ�����޸�
     */
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    /**
     *
     * ��Ⱦ��ͼ֮�����
     * �ͷ���Դ
     */
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
        System.out.println("afterCompletion");
    }
}
