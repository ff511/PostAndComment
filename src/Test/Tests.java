package Test;

import com.zzz.mvc.Mappers.AccountMapper;
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
                "com/zzz/mvc/config/Spring/spring-mybatis-dao.xml");
    }

    @Test
    public void selectOneUser() {
        logger.debug("start debug");
        AccountMapper accountMapper = applicationContext.getBean(AccountMapper.class);

        System.out.println(accountMapper.queryAccountInfoById("zzztttztzt@126.com"));
    }
}
