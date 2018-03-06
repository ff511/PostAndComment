package Test;

import com.zzz.mvc.Mappers.UserMapper;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    private ApplicationContext applicationContext;
    private Logger log = Logger.getLogger(test.class);

    @Before
    public void setUp() {
        applicationContext = new ClassPathXmlApplicationContext(
                "com/zzz/mvc/config/Spring/applicationContext.xml");
    }

    @Test
    public void selectOneUser() {
        log.debug("start debug");
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);
        System.out.println(userMapper.selectOneUser("0001"));
    }
}
