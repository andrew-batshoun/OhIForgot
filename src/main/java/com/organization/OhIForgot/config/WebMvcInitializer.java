package com.organization.OhIForgot.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
    protected Class < ? > [] getRootConfigClasses() {
        return new Class[] {
            HibernateConfiguration.class
        };
    }

    @Override
    protected Class < ? > [] getServletConfigClasses() {
        return new Class[] {
            MvcConfiguration.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {
            "/"
        };
    }
	
	

}