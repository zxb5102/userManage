package vic.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vic.model.BookMsg;

@Controller
public class BookController {

	/**
	 * 这里是用来测试 Spring 自定义 的校验器 这个校验器的话只能够传递一个对象 所以 的话下面的案例也是通过 一个 BookMsg 来测试的
	 * 
	 * @param bookMsgreturn
	 *            "book";
	 * @param result
	 * @return
	 */
	@RequestMapping("/getBook")
	public String getBook(@Validated BookMsg bookMsg, BindingResult result) {
		if (result.hasErrors()) {
			return "hasError";
		} else {
			return "book";
		}
	}

	@RequestMapping("/getBook2")
	public String getBook2(@Valid BookMsg bookMsg, BindingResult result) {
		System.out.println(result);
		if (result.hasErrors()) {
			System.out.println(result);
			return "hasError";
		} else {
			return "book";
		}
		// return null;
		// if(result.hasErrors()){
		// return "hasError";
		// }else{
		// return "book";
		// }
	}

//	@InitBinder
//	public void initBinder(DataBinder binder) {
//		// binder.setValidator(new BookNameValidator());
//	}

}
