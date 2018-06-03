package vic.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BookNameValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println(222);
		return String.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		System.out.println(111);
		String bookName = (String) obj;
		if (bookName.contains("vic")) {
			errors.rejectValue("bookName", null, null, "书名不能含有 vic 字符");
		}
	}

}
