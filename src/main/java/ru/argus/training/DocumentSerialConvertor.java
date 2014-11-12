package ru.argus.training;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter("serialConvertor")
public class DocumentSerialConvertor implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
			return null;
		}
		
		return value.replaceAll("\\s", "");
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return "";
		}
		
		int position = Integer.valueOf((String) component.getAttributes().get("whitespacePosition"));
		
		StringBuilder serial = new StringBuilder(5);
		serial.append(value);
		serial.insert(position, " ");
		return serial.toString();
	}

}
