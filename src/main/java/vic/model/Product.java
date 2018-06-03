package vic.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Product {

	private String name;
	
	/**
	 * 添加  json 格式化说明 yyyy-MM-dd
	 */
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date date;

	public Product() {
		super();
	}

	public Product(String name, Date date) {
		super();
		this.name = name;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", date=" + date + "]";
	}

}
