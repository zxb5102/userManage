package vic.util;

import org.springframework.core.convert.converter.Converter;

import vic.model.User;

public class UserConverter implements Converter<String, User>{

	@Override
	public User convert(String source) {
		try {
			String[] split = source.split(",");
			return new User(split[0],split[1]);			
		} catch (Exception e) {
			System.out.println(e);
			return new User();
		}
	}

	
}
