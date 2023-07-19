package com.masai.service;

import com.masai.dao.SupportDAO;
import com.masai.dao.SupportDAOImpl;
import com.masai.entity.SupportRepresentative;
import com.masai.exception.DuplicateDataException;
import com.masai.exception.NoRecordFound;

public class SupportServiceImpl implements SupportService{

	@Override
	public void addCSR(SupportRepresentative csr) throws DuplicateDataException {
		
		SupportDAO dao = new SupportDAOImpl();
		dao.addCSR(csr);
		
	}

	@Override
	public void logIn(String username, String password) throws NoRecordFound {
		
		SupportDAO dao = new SupportDAOImpl();
		dao.logIn(username,password);
		
	}

}
