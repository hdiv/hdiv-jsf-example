package org.hdiv.example.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator {

	/*
	 * (sin Javadoc)
	 * 
	 * @see javax.faces.validator.Validator#validate(javax.faces.context.FacesContext,
	 * javax.faces.component.UIComponent, java.lang.Object)
	 */
	public void validate(FacesContext facesContext, UIComponent comp, Object value) throws ValidatorException {

		boolean matchFound = false;
		try {
			String val = value.toString();

			// Set the email pattern string
			Pattern p = Pattern.compile(".+@.+\\.[a-z]+");

			// Match the given string with the pattern
			Matcher m = p.matcher(val);

			// check whether match is found
			matchFound = m.matches();
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage("Not a valid email");
			throw new ValidatorException(msg, e);
		}
		if (!matchFound) {
			FacesMessage msg = new FacesMessage("Not a valid email");
			throw new ValidatorException(msg);
		}

	}

}
