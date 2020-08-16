import com.devin.dao.UserMapper;
import com.devin.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml"})
public class test {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1(){
        System.out.println(userMapper);
        User user = userMapper.findUser((long)1);
        System.out.println(user.getUsername());
    }
}
