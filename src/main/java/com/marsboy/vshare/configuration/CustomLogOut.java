package com.marsboy.vshare.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomLogOut implements LogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		if (auth != null && auth.getDetails() != null) {
			try {
				request.getSession().invalidate();
				System.out.println("User Successfully Logout");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String URL = request.getContextPath() + "/";
		response.setStatus(HttpStatus.OK.value());
		response.sendRedirect(URL);
	}

}
