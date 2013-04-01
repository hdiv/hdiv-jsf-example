package org.hdiv.example.backingbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hdiv.example.bean.Account;
import org.hdiv.example.facade.AccountFacade;

@ManagedBean
@RequestScoped
public class NewAccountBean {

	private static final Log log = LogFactory.getLog(NewAccountBean.class);

	@ManagedProperty("#{accountFacade}")
	private AccountFacade accountFacade;

	private Account account = new Account();

	private String repeatPassword;

	private String[] locales = new String[] { "en", "eu" };

	public String createAccount() {

		this.accountFacade.newAccount(this.account);

		log.info("New account created with id:" + this.account.getUserId());

		return "/view/accountList?faces-redirect=true";
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
	 * @return the repeatPassword
	 */
	public String getRepeatPassword() {
		return repeatPassword;
	}

	/**
	 * @param repeatPassword
	 *            the repeatPassword to set
	 */
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	/**
	 * @param accountFacade
	 *            the accountFacade to set
	 */
	public void setAccountFacade(AccountFacade accountFacade) {
		this.accountFacade = accountFacade;
	}

	/**
	 * @return the locales
	 */
	public String[] getLocales() {
		return locales;
	}

}
