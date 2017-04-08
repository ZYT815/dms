package com.zyt;

import java.nio.charset.StandardCharsets;
import java.util.EnumSet;

import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		Dynamic charencodingFilter = servletContext.addFilter("charencodingFilter", CharacterEncodingFilter.class);
		charencodingFilter.setInitParameter("encoding", StandardCharsets.UTF_8.name());
		charencodingFilter.setInitParameter("forceEncoding", Boolean.TRUE.toString());
		charencodingFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), false, "/*");
		super.onStartup(servletContext);
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { AppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebAppConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
