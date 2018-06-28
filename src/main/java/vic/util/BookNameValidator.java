package vic.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import vic.model.BookMsg;

public class BookNameValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println(11);
		return BookMsg.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		BookMsg bookMsg = (BookMsg) obj;
		if (bookMsg.getName().contains("vic")) {
			errors.rejectValue("name", null, null, "书名不能含有 vic 字符");
		}
	}

}
