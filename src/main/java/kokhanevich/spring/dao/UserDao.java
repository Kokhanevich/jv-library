package kokhanevich.spring.dao;

import java.util.List;
import kokhanevich.spring.entity.User;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}
