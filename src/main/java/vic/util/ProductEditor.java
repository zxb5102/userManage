package vic.util;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.datetime.DateFormatter;

import vic.model.Product;

public class ProductEditor extends PropertyEditorSupport {

	@Override
	public String getAsText() {
		Product product = (Product) getValue();
		return product.toString();
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String[] productAry = text.split("#");
		if (productAry.length != 2) {
			return;
		}
		DateFormatter formatter = new DateFormatter("yyyy,MM,dd");
		formatter.setLenient(false);
		try {
			Date parse = formatter.parse(productAry[1], Locale.CHINA);
			setValue(new Product(productAry[0], parse));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
