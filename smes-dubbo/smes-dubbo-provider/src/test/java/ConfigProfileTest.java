import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Liang on 2018/11/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml","classpath:application-mybatis.xml"})
@ActiveProfiles("dev")
public class ConfigProfileTest {

    //读取当前环境的app配置文件
    @Value("${app.evn}")
    private String evnstr;

    @Test
    public void test() {
        System.out.println("当前运行环境:" + evnstr);
    }

}
