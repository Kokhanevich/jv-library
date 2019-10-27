package kokhanevych.spring.dao;

import java.util.List;
import java.util.Optional;

import kokhanevych.spring.entity.User;

public interface UserDao {
    void add(User user);

    Optional<User> getUserByUserName(String userName);

    Optional<User> getUser(Long id);

    List<User> listUsers();
}
