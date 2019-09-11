package spring;

import org.springframework.beans.factory.DisposableBean;

/**
 * Created by 44399 on 2019/8/31
 *
 * @author 44399
 */
public interface MessageService extends DisposableBean {
    String getMessage();
}
