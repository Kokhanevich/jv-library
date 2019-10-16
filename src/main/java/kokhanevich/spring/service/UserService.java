package kokhanevich.spring.service;

import java.util.List;
import kokhanevich.spring.entity.User;

public interface UserService {
    void add(User user);

    List<User> listUsers();
}
