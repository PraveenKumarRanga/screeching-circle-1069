package com.masai.dao;

import com.masai.entity.SupportRepresentative;
import com.masai.exception.DuplicateDataException;
import com.masai.exception.NoRecordFound;

public interface SupportDAO {

	void addCSR(SupportRepresentative csr) throws DuplicateDataException;

	void logIn(String username, String password) throws NoRecordFound;
	
	

}
