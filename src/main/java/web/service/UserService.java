package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> getList();

    User findById(long id);

    void delete(long id);

    void change(long id, User user);

    void addUsers();
}
