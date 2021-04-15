package org.example.openjpa.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

	@Bean
	public EntityManager entityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("DemoOpenJPA");
		EntityManager em = factory.createEntityManager();
		return em;
	}
}
