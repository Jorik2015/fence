package com.abner.action;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import ext.util.FacesUtils;

@Controller
@Scope("request")
public class LoginAction {
	private String username = "";
	private String password = "";
	private boolean rememberMe = false;
	private boolean loggedIn = false;

	public String doLogin() throws IOException, ServletException {
		ExternalContext context = FacesUtils.extContext();
		RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/j_spring_security_check");

		dispatcher.forward((ServletRequest) context.getRequest(),(ServletResponse) context.getResponse());

		FacesUtils.context().responseComplete();

		return null;
	}

	public void logout() {

	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public boolean isRememberMe() {
		return this.rememberMe;
	}

	public void setRememberMe(final boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	public boolean isLoggedIn() {
		return this.loggedIn;
	}

	public void setLoggedIn(final boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
}
