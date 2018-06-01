package vic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vic.model.User;
import vic.sservice.UserService;
import vic.util.Message;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/showUser/{userId}")
	public String showUser(@PathVariable String userId, Model model) {
		User user = userService.findUserById(userId);
		model.addAttribute(user);
		return "user";
	}

	@RequestMapping("/listUser")
	public String listUser(Model model) {
		List<User> userList = userService.findAllUser();
		model.addAttribute(userList);
		return "userList";
	}

	@RequestMapping(value = "/deleteUser/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Message deleteUser(@PathVariable String userId) {
		Message message = userService.deleteUserById(userId);
		return message;
	}

	@RequestMapping(value = "/addUser/name/{name}/age/{age}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Message addUser(User user) {
		System.out.println(user);
		Message message = userService.addNewUser(user);
		return message;
	}
}
