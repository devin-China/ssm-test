import com.devin.dao.UserMapper;
import com.devin.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml"})
public class TestDao {

    @Autowired
    private UserMapper userMapper;

//    to test findUser  method
    @Test
    public void test1(){
        User user = userMapper.findUser((long) 1);
        System.out.println(user.getEmail()+user.getUsername());
    }

//    to test add user
    @Test
    public void test2(){
        User user = new User();
        user.setUsername("devin");
        user.setEmail("deving@tom.com");
        user.setPassword("coassword");
        user.setPhoneNum("34324234234");
        user.setBirthday(new Date());

        userMapper.addUser(user);
        Long id = user.getId();
        System.out.println("id="+id);

    }
//    use pageHelper to find all users;
    @Test
    public void findAll(){
       PageHelper.startPage(1,4);
        List<User> userList = userMapper.findAll();
        for (User user:userList) {
            System.out.println(user.getUsername()+user.getBirthday());
        }

        PageInfo<User> userPageInfo = new PageInfo<>(userList);
        System.out.println("next page:"+userPageInfo.getNextPage());
        System.out.println("startRow:"+userPageInfo.getStartRow());

    }
}
