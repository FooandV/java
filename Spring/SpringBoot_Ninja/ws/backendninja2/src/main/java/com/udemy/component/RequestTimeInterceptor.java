package com.udemy.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**Esta clase es la que captura el tiempo de las peticiones  desde que entra el Request hasta que 
 * se devuelve un Response*/
 
/*Este componente de SpringMVC, por cada peticion que nos hagan entre por esta clase en los diferentes metodos*/
@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter{
	
	/**para calcular el tiempo y soltarlo en el log:*/
	private static final Log LOG= LogFactory.getLog(RequestTimeInterceptor.class); 

	/**	Este metodo se va ejecutar antes de entrar en el metodo "exampleString" del controlador:ExampleController **/
	//SE EJECUTA PRIMERO
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//se toma el objeto request y se setea el tiempo actual en el que entra, 
		//System.currentTimeMillis()= esto es la hora actual en milisegundos
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}
	/**	Este metodo se va ejecutar justo antes de presentar la vista en el navegador del metodo "exampleString" **/
	//SE EJECUTA DESPUES
	
	/**PARA DARLE DE ALTA A ESTE COMPONENTE SE DEBE DAR DE ALTA EN EL WebMvcConfig*/
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		/*obtenemos el tiempo actual*/
		long starTime = (long) request.getAttribute("startTime");
		LOG.info("Url to: '" + request.getRequestURL().toString() + "' in: '" + (System.currentTimeMillis() - starTime) + "'ms'");
	}

	
}
