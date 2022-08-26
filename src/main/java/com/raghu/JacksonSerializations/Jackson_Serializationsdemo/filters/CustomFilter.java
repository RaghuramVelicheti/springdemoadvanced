package com.raghu.JacksonSerializations.Jackson_Serializationsdemo.filters;

import java.io.IOException;
import java.net.http.HttpResponse;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class CustomFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		chain.doFilter(request, response);
		System.out.println("<=====================Filter Called=====================>");
		System.out.println(response.isCommitted());
		HttpServletResponse resp = ((HttpServletResponse) response);
		resp.addHeader("ServName", "FILTER ATTR");
		System.out.println("<=====================Header added=====================>");

	}

}
