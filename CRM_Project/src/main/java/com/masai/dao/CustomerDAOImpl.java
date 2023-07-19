package com.masai.dao;

import java.util.List;

import com.masai.entity.Customer;
import com.masai.entity.LoggedIn;
import com.masai.exception.DuplicateDataException;
import com.masai.exception.NoRecordFound;
import com.masai.exception.SomethingWentWrong;
import com.masai.utility.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class CustomerDAOImpl implements CustomerDAO{

	@Override
	public void addCustomer(Customer customer) throws DuplicateDataException, SomethingWentWrong {
		
		EntityManager em = null;
		
		try {
			em = EMUtils.createConection();
			Query query = em.createQuery(" SELECT Count(c) From Customer c WHERE username = :username");
							query.setParameter("username", customer.getUsername());
			
			
			if((long) query.getSingleResult()>0) {
				throw new DuplicateDataException("Customer is already present");
			}
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(customer);
			et.commit();
		
		}
		catch(PersistenceException pe) {
			throw new SomethingWentWrong("Customer already exists");
		}
		finally {
			if(em!=null) {
				em.close();
			}
		}
		
	}

	@Override
	public void logIn(String username, String password) throws NoRecordFound {
		
		EntityManager em = null;
		
		try {
			em = EMUtils.createConection();
			
			Query query = em.createQuery("SELECT c.id FROM Customer c WHERE username = :un AND password = :pw AND isDeleted = 1");
			
			query.setParameter("un", username);
			query.setParameter("pw", password);
			
			List<Integer> list = query.getResultList();
			
			if(list.size() == 0) {
				throw new NoRecordFound("User not found,Register as new customer");
				
			}
			LoggedIn.userid = list.get(0);
		}catch(PersistenceException pe) {
			System.out.println(pe.getMessage());
		}finally {
			if(em!= null) {
				em.close();
			}
		}
		
	}

}
