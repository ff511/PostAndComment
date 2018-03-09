package Test;

import com.zzz.mvc.Mappers.UserMapper;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tests {

    private ApplicationContext applicationContext;
    private final Logger logger = Logger.getLogger(Tests.class);

    @Before
    public void setUp() {
        applicationContext = new ClassPathXmlApplicationContext(
                "com/zzz/mvc/config/Spring/applicationContext.xml");
    }

    @Test
    public void selectOneUser() {
        logger.debug("start debug");
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);
        System.out.println(userMapper.selectOneUser("00010"));
    }
}
