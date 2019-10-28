package kokhanevych.spring.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import kokhanevych.spring.dao.RoleDao;
import kokhanevych.spring.dao.UserDao;
import kokhanevych.spring.entity.Role;
import kokhanevych.spring.entity.User;
import kokhanevych.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    public static final String ROLE_NAME = "USER";

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void add(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = roleDao.getRoleByName(ROLE_NAME)
                .orElseThrow(() -> new NoSuchElementException("Can’t find this role"));
        user.setRoles(Arrays.asList(role));
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> getUserByUserName(String userName) {
        return userDao.getUserByUserName(userName);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> getUser(Long id) {
        return userDao.getUser(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

}
