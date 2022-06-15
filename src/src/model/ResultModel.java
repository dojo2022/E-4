package model;
import java.io.Serializable;

public class ResultModel implements Serializable {
	private String message;
	private String backTo;

	public ResultModel() {
		this(null, null);
	}

	public ResultModel(String message, String backTo) {
		this.message = message;
		this.backTo = backTo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getBackTo() {
		return backTo;
	}

	public void setBackTo(String backTo) {
		this.backTo = backTo;
	}
}
