package com.example.customer.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.customer.model.Customer;

@Service
@Profile("dao")
public class CustomerServiceDaoImpl implements CustomerService {

	private EntityManagerFactory emf;
	
	@PersistenceUnit
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public List<Customer> getCustomers() {
		EntityManager em = this.emf.createEntityManager();
		return em.createQuery("from Customer", Customer.class).getResultList();
	}

	@Override
	public Customer getCustomer(int id) {
		EntityManager em = this.emf.createEntityManager();
		return em.find(Customer.class, id);
	}

	@Override
	public void addCustomer(Customer c) {
		EntityManager em = this.emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();

	}

	@Override
	public void delete(int id) {
		EntityManager em = this.emf.createEntityManager();
		Customer customer = em.find(Customer.class, id);
		em.getTransaction().begin();
		em.remove(customer);
		em.getTransaction().commit();
	}

}
