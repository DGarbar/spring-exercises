package ua.procamp.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.procamp.dao.UserDao;
import ua.procamp.model.jpa.Role;
import ua.procamp.model.jpa.RoleType;
import ua.procamp.model.jpa.User;

/**
 * This class proovides {@link User} related service logic.
 * <p>
 * todo: 1. Configure {@link UserService} bean as spring service
 * todo: 2. Inject {@link UserDao} using constructor-based injection
 * todo: 3. Enable transaction management on class level
 * todo: 4. Configure {@link UserService#getAll()} as read-only method
 * todo: 4. Configure {@link UserService#getAllAdmins()} as read-only method
 */
@Service
@Transactional
public class UserService {

	private UserDao userDao;

	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}

	public void save(User user) {
		userDao.save(user);
	}

	@Transactional(readOnly = true)
	public List<User> getAll() {
		return userDao.findAll();
	}

	@Transactional(readOnly = true)
	public List<User> getAllAdmins() {
		return userDao.findAll()
			.stream()
			.filter(user -> isAdmin(user.getRoles()))
			.collect(Collectors.toList());
	}

	private boolean isAdmin(Set<Role> roles) {
		return roles.stream()
			.anyMatch(role -> role.getRoleType().equals(RoleType.ADMIN));
	}

	public void addRole(Long userId, RoleType roleType) {
		Role role = new Role();
		role.setRoleType(roleType);
		Optional.ofNullable(userDao.findById(userId))
			.ifPresent(user -> user.addRole(role));
	}
}
