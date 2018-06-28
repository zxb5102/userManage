package vic.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class BookMsg {

	@Length(min=8,message="fdsfsf")
	@NotNull
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "BookMsg [name=" + name + "]";
	}

}
