package next.controller;

import core.mvc.ModelAndView;

public class Result {
	private boolean success;
	private String errorMessage;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Result(boolean success, String errorMessage) {
		super();
		this.success = success;
		this.errorMessage = errorMessage;
	}

	public Result(boolean success) {
		this.success = success;
	}

	public void addErrorMessage(ModelAndView mav) {
		if(success)
			return;
		mav.addObject("errorMessage", errorMessage);
	}

}
