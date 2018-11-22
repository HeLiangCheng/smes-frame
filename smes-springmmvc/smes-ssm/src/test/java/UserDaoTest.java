import com.hlc.styd.smes.web.dao.IUserDao;
import com.hlc.styd.smes.web.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by Liang on 2018/11/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml","classpath:mybatis.xml"})
public class UserDaoTest {

    @Autowired
    private IUserDao userDao;

    @Test
    public void daotest1() {
        User user = new User();
        user.setName("test");
        user.setUsername("test_user");
        user.setPassword("123456");
        user.setGander("男");
        user.setBirthday(new Date());
        userDao.save(user);
    }

    @Test
    public void daotest2() {
        User user = null;
        int num = userDao.count(user);
        System.out.println("数据总数：" + num);
    }

}
