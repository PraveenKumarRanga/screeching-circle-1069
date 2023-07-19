package com.masai.service;

import com.masai.dao.CustomerDAO;
import com.masai.dao.CustomerDAOImpl;
import com.masai.entity.Customer;
import com.masai.exception.DuplicateDataException;
import com.masai.exception.NoRecordFound;
import com.masai.exception.SomethingWentWrong;

public class CustomerServiceImpl implements CustomerService{

	@Override
	public void addCustomer(Customer customer) throws DuplicateDataException,SomethingWentWrong {
		// TODO Auto-generated method stub
		CustomerDAO dao = new CustomerDAOImpl();
		dao.addCustomer(customer);
	}

	@Override
	public void logIn(String username, String password) throws NoRecordFound {
		
		CustomerDAO dao = new CustomerDAOImpl();
		dao.logIn(username,password);
		
	}

}
