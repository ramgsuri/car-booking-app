package com.carbooking;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
* The Class NonDicomUploadCORSFilter.
*/
@Component
public class StoreCORSFilter implements Filter {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger( StoreCORSFilter.class );

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init( FilterConfig filterConfig ) throws ServletException {
        LOGGER.debug( "CORS init" );
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse,
     * javax.servlet.FilterChain)
     */
    @Override
    public void doFilter( ServletRequest request, ServletResponse res, FilterChain chain ) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse)res;
        response.setHeader( "Access-Control-Allow-Origin", "*" );
        response.setHeader( "Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT" );
        response.setHeader( "Access-Control-Max-Age", "3600" );
        response.setHeader( "Access-Control-Allow-Headers", "Authorization, X-SSL-Client-DN, Predix-Zone-Id, Origin, x-requested-with, Content-Type, Accept" );
        response.setHeader( "Access-Control-Allow-Credentials", "*" );
        chain.doFilter( request, res );
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
        LOGGER.debug( "CORS destroy" );
    }

}
