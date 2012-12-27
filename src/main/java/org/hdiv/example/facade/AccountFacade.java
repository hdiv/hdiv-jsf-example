package org.hdiv.example.facade;

import java.util.List;

import org.hdiv.example.bean.Account;

public interface AccountFacade {

	/**
	 * Create a new Account in the information system
	 * 
	 * @param account
	 *            New user account
	 */
	public void newAccount(Account account);

	/**
	 * Paged account list.
	 * 
	 * @param offset
	 *            base position
	 * @param count
	 *            size of the page
	 * @return Account list
	 */
	public List<Account> getAccounts(int offset, int count);

	/**
	 * Get an Account from the information system.
	 * 
	 * @param userId
	 *            account identifier.
	 * @return Account instance
	 */
	public Account getAccount(String userId);

}
