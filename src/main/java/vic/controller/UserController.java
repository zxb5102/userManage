package vic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		if(user != null){
			model.addAttribute(user);
		}
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

	/**
	 * 测试  类型转化 通过  /addUser/20,xiaoming 来添加用户
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/addUser/{user}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Message addUserByTypeConversion(@PathVariable("user")	User user) {
		System.out.println(user);
		Message message = userService.addNewUser(user);
		return message;
	}
	
	@RequestMapping(value = "/updateUser", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Message updateUserById(@ModelAttribute User user) {
		Message message = userService.updateUserById(user);
		return message;
	}
	
	/**
	 * 在更新操作之前 先根据是否存在id判断是不是更新操作 在更新操作之前先添加进一个对象 适用于hibernate
	 * @param id
	 * @return
	 */
	@ModelAttribute("user")
	public User applyModel(@RequestParam(required=false) String id){
		User newUser = new User();
		if(id != null){
			newUser = new User("100", "testUserName");
			return newUser;
		}
		return null;
	}
	
}
