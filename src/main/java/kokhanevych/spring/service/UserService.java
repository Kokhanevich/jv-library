package kokhanevych.spring.service;

import java.util.List;
import java.util.Optional;

import kokhanevych.spring.entity.User;

public interface UserService {
    void add(User user);

    Optional<User> getUserByUserName(String userName);

    Optional<User> getUser(Long id);

    List<User> listUsers();
}
