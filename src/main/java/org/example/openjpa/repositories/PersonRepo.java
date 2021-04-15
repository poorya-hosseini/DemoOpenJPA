package org.example.openjpa.repositories;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.example.openjpa.entities.Person;
import org.example.openjpa.utility.DemoEntityManager;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope
public class PersonRepo {

	//	@PersistenceContext(unitName = "DemoOpenJPA", type = PersistenceContextType.EXTENDED)

	public List<Person> findAll() throws Exception {
		try (DemoEntityManager dem = new DemoEntityManager()) {
			EntityManager em = dem.getEntityManager();
			Query q = em.createQuery("SELECT Person FROM Person p ORDER BY p.id");
			List<Person> personList = (List<Person>) q.getResultList();
			return personList;
		}

	}

	public Optional<Person> findById(long id) throws Exception {
		try (DemoEntityManager dem = new DemoEntityManager()) {
			EntityManager em = dem.getEntityManager();
//			CriteriaBuilder qb = em.getCriteriaBuilder();
//			CriteriaQuery qdef = qb.createQuery();
//			Root<Person> person = qdef.from(Person.class);
//			qdef.where(person.get(Person_.id).equal(id));

			TypedQuery<Person> q = em.createQuery("SELECT p FROM Person p WHERE p.id =" + id, Person.class);
			Person p = q.getSingleResult();
			Optional<Person> person = Optional.ofNullable(p);
			Optional.of(q.getSingleResult());
			return person;
		}

	}

	public void save(Person person) throws Exception {
		try (DemoEntityManager dem = new DemoEntityManager()) {
			EntityManager em = dem.getEntityManager();

			em.getTransaction().begin();
			em.persist(person);
			em.getTransaction().commit();
		}
	}
//
//	public void updateItem(int id, String name, String description, float price, int categoryID) {
//
//		InventoryItem item = em.find(InventoryItem.class, id);
//		item.setItemName(name);
//		item.setItemDescription(description);
//		item.setItemPrice(price);
//		item.setCategory(getSingleCategory(categoryID));
//
//		em.getTransaction().begin();
//		em.merge(item);
//		em.getTransaction().commit();
//	}
//
//	public void deleteItem(int id) {
//		InventoryItem item = em.find(InventoryItem.class, id);
//
//		em.getTransaction().begin();
//		em.remove(item);
//		em.getTransaction().commit();
//	}
//
//	//Category Methods
//	public List<InventoryCategory> getAllCategories() {
//		Query q = em.createQuery("SELECT cat FROM InventoryCategory cat ORDER BY cat.categoryName");
//
//		return (List<InventoryCategory>) q.getResultList();
//	}
//
//	public InventoryCategory getSingleCategory(int id) {
//		Query q = em.createQuery("SELECT cat FROM InventoryCategory cat WHERE cat.id=" + id);
//		return (InventoryCategory) q.getSingleResult();
//	}
//
//	public void addCategory(String name, String description) {
//		InventoryCategory cat = new InventoryCategory();
//		cat.setCategoryName(name);
//		cat.setCategoryDescription(description);
//
//		em.getTransaction().begin();
//		em.persist(cat);
//		em.getTransaction().commit();
//	}
//
//	public void updateCategory(int id, String name, String description) {
//
//		InventoryCategory cat = em.find(InventoryCategory.class, id);
//		cat.setCategoryName(name);
//		cat.setCategoryDescription(description);
//
//		em.getTransaction().begin();
//		em.merge(cat);
//		em.getTransaction().commit();
//	}
//
//	public void deleteCategory(int id) {
//		InventoryCategory cat = em.find(InventoryCategory.class, id);
//
//		em.getTransaction().begin();
//		em.remove(cat);
//		em.getTransaction().commit();
//	}

}
