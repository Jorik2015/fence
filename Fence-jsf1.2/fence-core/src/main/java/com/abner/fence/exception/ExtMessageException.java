package com.abner.fence.exception;

import javax.faces.application.FacesMessage;

public class ExtMessageException extends RuntimeException {
	
	private FacesMessage facesMessage;

	private static final long serialVersionUID = -1324289524481242346L;
	
	public ExtMessageException() {
		super();
	}

	public ExtMessageException(String message, Throwable cause) {
		super(message, cause);
	}

	public ExtMessageException(String message) {
		super(message);
	}

	public ExtMessageException(Throwable cause) {
		super(cause);
	}

	public ExtMessageException(FacesMessage facesMsg) {
		super(facesMsg.getSummary());
		this.facesMessage = facesMsg;
	}

	public FacesMessage getFacesMessage() {
		return facesMessage;
	}

	public void setFacesMessage(FacesMessage facesMessage) {
		this.facesMessage = facesMessage;
	}
}
