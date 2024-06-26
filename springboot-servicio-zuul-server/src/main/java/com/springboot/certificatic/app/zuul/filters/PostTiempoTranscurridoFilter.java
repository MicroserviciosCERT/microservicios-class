package com.springboot.certificatic.app.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PostTiempoTranscurridoFilter extends ZuulFilter{
	
	private static Logger log = LoggerFactory.getLogger(PreTiempoTranscurridoFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		Long tiempoInicio =(Long) request.getAttribute("tiempoInicio");
		Long tiempoFinal = System.currentTimeMillis();
		Long tiempoTotal = tiempoFinal - tiempoInicio;
		log.info("Tiempo transcurrido = "+ tiempoFinal);
		log.info("Tiempo transcurrido en segundos = " + tiempoFinal.doubleValue()/1000);
	
		return null;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}
	
	
	

}
