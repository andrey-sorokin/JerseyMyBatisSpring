package com.rstyle.core.info.storage.rest.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Реализация фильтра для CORS-compliant REST API
 
public class CrossOriginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
        ServletException {
        final HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        final HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");

        if ("OPTIONS".equalsIgnoreCase(httpServletRequest.getMethod())) {
            httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
            httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            String requestHeaders = httpServletRequest.getHeader("Access-Control-Request-Headers");
            if (null != requestHeaders && !requestHeaders.equals("")) {
                httpServletResponse.addHeader("Access-Control-Allow-Headers", requestHeaders);
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
