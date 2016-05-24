package Dao;
import Enity.User;
/**
 * Created by wangda on 16/5/18.
 */
public interface UserDao {
    void save(User user);
    User findbyId(int id);
    void delete(User user);
    void upDate(User user);
}
