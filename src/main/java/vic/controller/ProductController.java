package vic.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vic.model.Product;
import vic.util.ProductEditor;

@Controller
public class ProductController {
	

	/**
	 * 测试 返回的 Date格式的数据的格式化 
	 * @return
	 */
	@RequestMapping("/getProduct")
	@ResponseBody
	public Product getProduct(){
		Product product = new Product("testProduct", new Date());
		return product;
	}
	
	/**
	 * 测试 spring 的CustomDateEditor 的效果 直接转化 yyyy,MM,dd 的日期字符串 到 Date 的效果
	 * @param name
	 * @param date
	 * @return
	 */
	@RequestMapping("/saveProduct") 
	public String saveProduct(String name,Date date,Model model){
		Product product = new Product(name, date);
		model.addAttribute(product);
		return "product";
	}
	
	/**
	 * 测试自定义的  格式转化器  转化 productName#yyyy,MM,dd 格式的字符串到 Product 对象
	 * @param product
	 * @return
	 */
	@RequestMapping("/saveProductFromText") 
	public String saveProductFromText(@RequestParam("productStr") Product product,Model model){
		model.addAttribute(product);
		return "product";
	}
	
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy,MM,dd");
        dateFormat.setLenient(false);
        ProductEditor productEditor = new ProductEditor();
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
        binder.registerCustomEditor(Product.class, productEditor);
    }
	
}
