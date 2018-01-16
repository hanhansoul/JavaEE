package old.exceptionHandler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/5/4.
 */
public class ExceptionHandlerTest {

    @ExceptionHandler({ArithmeticException.class})
    public ModelAndView handlerArithmeticException(Exception ex) {
        System.out.println("exception: " + ex);
        ModelAndView mv = new ModelAndView("error");
        return mv;
    }

}
