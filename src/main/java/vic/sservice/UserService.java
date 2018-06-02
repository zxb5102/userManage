package vic.sservice;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vic.dao.UserMapper;
import vic.model.User;
import vic.util.Message;

@Service
public class UserService {

	@Autowired
	public UserMapper userMapper;

	public User findUserById(String userId) {
		return userMapper.findUserById(userId);
	};

	public List<User> findAllUser() {
		return userMapper.findAllUser();
	};

	public Message deleteUserById(@Param("userId") String userId) {
		int flag = userMapper.deleteUserById(userId);
		System.out.println(flag);
		Message message = new Message();
		if (flag != 0) {
			message.setSuccess(true);
		}
		return message;
	};

	public Message addNewUser(User user) {
		int flag = userMapper.addNewUser(user);
		Message message = new Message();
		if (flag != 0) {
			message.setSuccess(true);
		}
		return message;
	};
	
	public Message updateUserById(User user){
		int flag = userMapper.updateUserById(user);
		Message message = new Message();
		if (flag != 0) {
			message.setSuccess(true);
		}
		return message;
	}
}
