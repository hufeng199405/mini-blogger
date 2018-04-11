package component;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-04-11 17:54
 * @desc
 * @since 1.8
 */
@Service
public class ApplicationFactory implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        context = applicationContext;
    }

    public static Object getBean(String bean) {

        return context.getBean(bean);
    }
}
