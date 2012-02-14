package com.fence.web.spring;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AbstractProcessingFilter;

import ext.util.FacesUtils;

public class LoginErrorPhaseListener implements PhaseListener {

	private static final long serialVersionUID = -1216620620302322995L;

	public void beforePhase(final PhaseEvent arg0) {
		Exception e = (Exception) FacesUtils.extContext().getSessionMap().get(
				AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY);

		if (e instanceof BadCredentialsException) {
			FacesUtils
					.extContext()
					.getSessionMap()
					.put(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY,null);
			FacesUtils.addErrorMessage("Username or password not valid.");
		}
	}

	public void afterPhase(final PhaseEvent arg0) {
	}

	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}
}
