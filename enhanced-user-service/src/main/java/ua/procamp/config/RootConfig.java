package ua.procamp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * This class is provides root Java config for Spring application.
 * <p>
 * todo: 0. PLEASE NOTE, THAT SOME REQUIRED STEPS ARE OMITTED IN THE TODO LIST AND YOU HAVE TO DO IT ON YOUR OWN
 * <p>
 * todo: 1. Configure {@link PlatformTransactionManager} bean with name "transactionManager"
 * todo: 2. Enable transaction management
 */
@Configuration
public class RootConfig {

	@Bean
	public PlatformTransactionManager transactionManager(){

	}

}

