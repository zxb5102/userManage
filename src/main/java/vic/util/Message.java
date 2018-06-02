package vic.util;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * 设置了 一个 jsonView 格式化 过滤字段
 * @author Administrator
 *
 */
public class Message {

	@JsonView(MessageView.DefaultView.class)
	public boolean success;

	@JsonView(MessageView.DefaultView.class)
	public String msg;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Message [success=" + success + ", msg=" + msg + "]";
	}

}
