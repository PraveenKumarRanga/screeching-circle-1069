package com.masai.service;

import java.util.Scanner;

import com.masai.entity.SupportRepresentative;
import com.masai.exception.DuplicateDataException;
import com.masai.exception.NoRecordFound;
import com.masai.exception.SomethingWentWrong;

public interface SupportService {

	void addCSR(SupportRepresentative csr) throws DuplicateDataException;

	void logIn(String username, String password ) throws NoRecordFound;

	void viewStatus() throws SomethingWentWrong;

	void viewIssue() throws SomethingWentWrong;

	void assignToSelf() throws SomethingWentWrong;

	void assignToOther(int id) throws SomethingWentWrong;

	void replyToIssue(int id, Scanner sc) throws SomethingWentWrong;



}
