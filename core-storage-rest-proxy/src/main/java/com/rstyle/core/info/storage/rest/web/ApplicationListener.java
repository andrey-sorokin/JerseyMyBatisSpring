package com.rstyle.core.info.storage.rest.web;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;

import com.wordnik.swagger.jersey.JerseyApiReader;

public class ApplicationListener extends ContextLoaderListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
        JerseyApiReader.setFormatString("");
    }
}
