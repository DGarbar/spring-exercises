package ua.procamp.config;

import javax.persistence.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * This class provides root application configuration. It scans for all available beans and enables declarative
 * transaction management.
 * <p>
 * todo: 1. Mark this class as config
 * todo: 2. Enable component scanning for package "ua.procamp"
 * todo: 3. Configure JPA {@link PlatformTransactionManager} with bean name "transactionManager"
 * todo: 4. Enable declarative transaction management
 */
@Configuration
@ComponentScan(value = "ua.procamp")
public class RootConfig {

	private EntityManagerFactory entityManagerFactory;

	public RootConfig(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}


	@Bean
	public PlatformTransactionManager transactionManager(){
		return new JpaTransactionManager(entityManagerFactory);
	}

}
