package org.hdiv.example.backingbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import org.hdiv.example.bean.Account;
import org.hdiv.example.facade.AccountFacade;

@ManagedBean
@RequestScoped
public class AccountListBean {

	@ManagedProperty("#{accountFacade}")
	private AccountFacade accountFacade;

	private List<Account> accounts;

	private int pageSize = 5;

	@ManagedProperty("#{param.index > 0?param.index:0}")
	private int index;

	public String accountList() {

		this.loadAccountList();

		return "/view/accountList?faces-redirect=true";
	}

	public String accountListPrev() {

		this.index -= this.pageSize;
		this.loadAccountList();

		return "/view/accountList";
	}

	public String accountListNext() {

		this.index += this.pageSize;
		this.loadAccountList();

		return "/view/accountList";
	}

	public void accountListPrevAL(ActionEvent event) {

		this.index -= this.pageSize;
		this.loadAccountList();
	}

	public void accountListNextAL(ActionEvent event) {

		this.index += this.pageSize;
		this.loadAccountList();
	}

	private void loadAccountList() {

		this.accounts = this.accountFacade.getAccounts(this.index, this.pageSize);
	}

	public List<Account> getAccounts() {

		if (this.accounts == null) {
			this.loadAccountList();
		}
		return this.accounts;
	}

	public boolean isFirstPage() {
		return this.index == 0;
	}

	public boolean isLastPage() {
		return this.getAccounts().size() < this.pageSize;
	}

	/**
	 * @param accountFacade
	 *            the accountFacade to set
	 */
	public void setAccountFacade(AccountFacade accountFacade) {
		this.accountFacade = accountFacade;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
