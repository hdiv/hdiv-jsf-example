package org.hdiv.example.backingbean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class HomeBean {

	public void home() {
		try {
			String applicationName = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect(applicationName + "/view/accountList.faces");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
