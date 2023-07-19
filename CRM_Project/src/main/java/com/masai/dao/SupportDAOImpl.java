package com.masai.dao;

import java.util.List;

import com.masai.entity.LoggedIn;
import com.masai.entity.SupportRepresentative;
import com.masai.exception.DuplicateDataException;
import com.masai.exception.NoRecordFound;
import com.masai.utility.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class SupportDAOImpl implements SupportDAO{

	@Override
	public void addCSR(SupportRepresentative csr) throws DuplicateDataException {
		
		EntityManager em = null;
		
		try {
			em = EMUtils.createConection();
			
			Query query = em.createQuery("SELECT Count(c) FROM SupportRepresentative c WHERE username = :username");
			query.setParameter("username", csr.getUsername());
			
			if((long) query.getSingleResult()>0) {
				throw new DuplicateDataException("Account already exits");
			}
			
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(csr);
			et.commit();
		}catch(PersistenceException e) {
			throw new DuplicateDataException(e.getMessage());
		}
		finally {
			em.close();
		}
		
		
	}

	@Override
	public void logIn(String username, String password) throws NoRecordFound {
		EntityManager em = null;
		
		try{
			
			em = EMUtils.createConection();
			
			Query query = em.createQuery("SELECT c.id FROM SupportRepresentative c WHERE username = :un AND password = :pw AND isClosed = 1");
			query.setParameter("un", username);
			query.setParameter("pw", password);
			
			List<Integer> list = query.getResultList();
			
			if(list.size()==0) {
				throw new NoRecordFound("Account does not exists");
			}
			
			LoggedIn.userid = list.get(0);
			
			
		}catch(PersistenceException pe) {
			throw new NoRecordFound(pe.getMessage());
		}finally {
			if(em!=null) {
				em.close();
			}
		}
		
		
	}

}
