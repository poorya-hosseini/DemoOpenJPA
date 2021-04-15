package org.example.openjpa.utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class DemoEntityManager implements AutoCloseable{

	private EntityManagerFactory factory;
	private EntityManager em;

	public EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("DemoOpenJPA");
		em = factory.createEntityManager();
		return em;
	}

	@Override
	public void close() throws Exception {
		em.close();
	}
}
