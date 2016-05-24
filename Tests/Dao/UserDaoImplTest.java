package Dao;

import Enity.User;
import com.opensymphony.xwork2.interceptor.annotations.Before;
import junit.framework.TestCase;

/**
 * Created by wd on 2016/5/18.
 */
public class UserDaoImplTest extends TestCase {

    @Before
    public void setUp() throws Exception {
    }

    public void testSave() throws Exception {
        UserDao userDao = new UserDaoImpl();
        try {
            User user = new User();
            user.setId(20);
            user.setName("zhangsan");
            user.setPassword("999999");
            user.setType("admin");
            userDao.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testFindbyId() throws Exception {

    }

    public void testDelete() throws Exception {

    }

    public void testUpDate() throws Exception {

    }
}