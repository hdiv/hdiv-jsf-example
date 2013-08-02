package org.hdiv.example.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hdiv.example.bean.Account;

@ManagedBean(name = "accountFacade")
@ApplicationScoped
public class AccountFacadeImpl implements AccountFacade {

	private static final Log log = LogFactory.getLog(AccountFacadeImpl.class);

	private static final int ACCOUNT_COUNT = 28;

	private List<Account> accounts = new ArrayList<Account>();

	public AccountFacadeImpl() {
		for (int i = 0; i < ACCOUNT_COUNT; i++) {
			Account account = new Account();
			account.setAddress1("Address1" + i);
			account.setAddress2("Address2" + i);
			account.setUserId("User" + i);
			account.setCity("City" + i);
			account.setCountry("Country" + i);
			account.setCreationDate(new Date());
			account.setEmail("Email" + i);
			account.setFirstName("FirstName" + i);
			account.setLastName("LastName" + i);
			account.setLocale("EN");
			account.setPhone("555-555-55" + i);
			account.setState("State" + i);
			account.setZip("Zip" + i);

			this.accounts.add(account);
		}

	}

	public void newAccount(Account account) {

		this.accounts.add(account);

		log.info("Account created");
	}

	public Account getAccount(String userId) {

		for (Account account : this.accounts) {
			if (account.getUserId().equals(userId)) {
				return account;
			}
		}
		return null;
	}

	public List<Account> getAccounts(int offset, int count) {

		int end = offset + count;
		if ((offset + count) > this.accounts.size()) {
			end = this.accounts.size();
		}
		return this.accounts.subList(offset, end);
	}

}
