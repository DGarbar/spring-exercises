package ua.procamp.dao;

import ua.procamp.model.jpa.User;

import java.util.List;

/**
 * User Data Access Object (DAO) API
 */
public interface UserDao {
    List<User> findAll();

    User findById(long id);

    void save(User user);
}
