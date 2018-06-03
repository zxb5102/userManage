package vic.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class HomeController {

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/product")
	public String product(){
		return "product";
	}
	
	@RequestMapping("/error")
	public String error() {
		int i = 1 / 0;
		return "error";
	}

	@RequestMapping("/uploadSuccess")
	public String uploadSuccess() {
		return "uploadSuccess";
	}

	@PostMapping("/upload")
	public String handleFormUpload(@RequestParam(value="name") String name, @RequestParam("file") CommonsMultipartFile  file)
			throws IOException {
		String fileName = file.getOriginalFilename();
		if(name != null && !name.equals("")){
			fileName = name;
		}
		System.out.println(fileName);
		File targetFile = new File("C:/Users/Administrator/Desktop/blog/first/WebContent/upload/" + fileName);
		InputStream inputStream = file.getInputStream();
		FileUtils.copyInputStreamToFile(inputStream, targetFile);
		return "redirect:uploadSuccess";
	}
}
