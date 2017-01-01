package com.vicky.gatsby.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializerwebxml extends AbstractAnnotationConfigDispatcherServletInitializer {

	private static final Logger logger = LoggerFactory.getLogger(Dispatcherconfig.class);

	
	@Override
	protected Class<?>[] getRootConfigClasses() {
	logger.debug("starting of  getRootConfigClasses");
		return new Class[]{Dispatcherconfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		logger.debug("starting of  getServletConfigClasses");
		return new Class[]{Dispatcherconfig.class};
	
		
	}

	@Override
	protected String[] getServletMappings() {
		logger.debug("starting of  getServletMappings");
		return new String[]{"/"};
		}
	
}
