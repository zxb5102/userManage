package vic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;

import vic.util.Message;
import vic.util.MessageView;

@ControllerAdvice("vic.controller")
public class ControllerExceptionHandler {

	/**
	 * 去掉了 xml 的jar包现在默认都是返回 json格式 
	 * 全局的异常处理
	 * @param e
	 * @param request
	 * @param response
	 * @return
	 */
	@ExceptionHandler
	@ResponseBody
	@JsonView(MessageView.DefaultView.class)
	public Message handleException(Exception e,HttpServletRequest request, HttpServletResponse response) {
		Message message = new Message();
		message.setSuccess(false);
		message.setMsg(e.getMessage());
		System.out.println(e);
		return message;
	}

}
