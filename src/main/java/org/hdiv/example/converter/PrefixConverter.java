package org.hdiv.example.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("prefixConverter")
public class PrefixConverter implements Converter {

	private String prefix = "(+34)";

	public Object getAsObject(FacesContext context, UIComponent comp, String text) {

		try {
			if (text.startsWith(prefix)) {
				return Integer.valueOf(text.substring(5));
			} else {
				return Integer.valueOf(text);
			}
		} catch (IllegalArgumentException e) {
			throw new ConverterException(e);
		}

	}

	public String getAsString(FacesContext context, UIComponent comp, Object obj) {

		return prefix + obj.toString();

	}

}
