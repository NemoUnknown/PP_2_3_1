package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.model.User;

import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private UserDAO userDAO;

    public UserServiceImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getList() {
        return userDAO.getList();
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(long id) {
        return userDAO.findById(id);
    }

    @Override
    public void delete(long id) {
        userDAO.delete(id);
    }

    @Override
    public void change(long id, User user) {
        userDAO.change(id, user);
    }

    @PostConstruct
    private void init() {
        System.out.println("Получена зависимость: " + userDAO);
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Уничтожен компонент UserService");
    }
}
