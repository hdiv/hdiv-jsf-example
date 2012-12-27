package org.hdiv.example.backingbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.hdiv.example.bean.Account;
import org.hdiv.example.facade.AccountFacade;

@ManagedBean
@RequestScoped
public class AccountDetailBean {

	@ManagedProperty("#{accountFacade}")
	private AccountFacade accountFacade;

	private Account account;

	@ManagedProperty("#{param.userId}")
	private String userId;

	public String viewAccount() {
		this.account = this.accountFacade.getAccount(this.userId);
		return "/view/accountDetail";
	}

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account
	 *            the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @param accountFacade
	 *            the accountFacade to set
	 */
	public void setAccountFacade(AccountFacade accountFacade) {
		this.accountFacade = accountFacade;
	}

}
