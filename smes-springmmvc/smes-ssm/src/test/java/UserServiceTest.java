import com.hlc.styd.smes.web.entity.User;
import com.hlc.styd.smes.web.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Liang on 2018/11/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml","classpath:mybatis.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void countService(){
        User user = new User();
        int count = userService.count(user);
        System.out.println(count);
    }

}
