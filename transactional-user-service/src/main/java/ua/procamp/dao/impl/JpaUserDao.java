package ua.procamp.dao.impl;

import java.util.List;
import javax.persistence.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.procamp.dao.UserDao;
import ua.procamp.model.jpa.User;

/**
 * This class implements {@link UserDao} using JPA.
 * <p>
 * todo: 1. Configure {@link JpaUserDao} bean as Spring Repository with name "userDao"
 * todo: 2. Enable transaction management on class level
 * todo: 3. Inject persistence context into {@link EntityManager} field
 */
@Repository("userDao")
@Transactional
public class JpaUserDao implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<User> findAll() {
		return entityManager.createQuery("Select u from User u", User.class).getResultList();
	}

	@Override
	public User findById(long id) {
		return entityManager.find(User.class,id);
	}

	@Override
	public void save(User user) {
		entityManager.persist(user);
	}
}
