package ru.argus.training;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Example from official <a href="http://docs.oracle.com/javaee/6/tutorial/doc/gkhpa.html" target="_blank">JEE tutorial</a> 
 * @author l.vygovsky
 *
 */
@Logged
@Interceptor
public class LoggerInterceptor implements Serializable {
	private static final long serialVersionUID = 3767519741841842480L;
	
	private static final Logger log = LoggerFactory.getLogger(LoggerInterceptor.class);
	
	
    public LoggerInterceptor() {
    }

    @AroundInvoke
    public Object logMethodEntry(InvocationContext invocationContext)
            throws Exception {
        log.trace("Entering method: "
                + invocationContext.getMethod().getName() + " in class "
                + invocationContext.getMethod().getDeclaringClass().getName());

        return invocationContext.proceed();
    }
}
