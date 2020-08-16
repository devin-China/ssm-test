import com.devin.domain.User;
import com.devin.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-service.xml","classpath:applicationContext-dao.xml"})
public class test {

    @Autowired
    public UserService userService;

    @Test
    public void test1(){

        System.out.println(userService);
        User user = userService.findUser((long) 1);
        System.out.println(user.getUsername());
    }
}
