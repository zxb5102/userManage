package vic.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vic.util.BookNameValidator;

@Controller
public class BookController {

	@RequestMapping("/getBook")
	public String getBook(@Validated String name) {
		return "book";
	}

	@InitBinder
	public void initBinder(DataBinder binder) {
		System.out.println(3332);
		binder.setValidator(new BookNameValidator());
	}

}
