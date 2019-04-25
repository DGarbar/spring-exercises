package ua.procamp.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.procamp.model.jpa.User;

/**
 * This interface represents a data access object (DAO) for {@link User}.
 * <p>
 * todo: 0. PLEASE NOTE, THAT SOME REQUIRED STEPS ARE OMITTED IN THE TODO LIST AND YOU HAVE TO DO IT ON YOUR OWN
 * <p>
 * todo: 1. Configure {@link UserRepository} as {@link JpaRepository} for class User
 * todo: 2. Create method that finds a list of Users by address city using Spring Data method name convention
 * todo: 3. Create method that finds optional user by email fetching its address and roles using {@link org.springframework.data.jpa.repository.Query}
 * todo: 4. Add custom User repository interface
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	List<User> findByAddressCity(String cityName);

	@Query("SELECT u FROM USER u WHERE u.email = ?1")
	Optional<User> findByEmail(String email);

}
