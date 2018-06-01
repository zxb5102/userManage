package vic.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import vic.model.User;

public interface UserMapper {

	User findUserById(@Param("userId") String userId);

	List<User> findAllUser();

	int deleteUserById(@Param("userId") String userId);

	int updateUserById(@Param("userId") String userId, @Param("user") User user);

	int addNewUser(@Param("user") User user);
}
