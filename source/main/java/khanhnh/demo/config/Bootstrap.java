package khanhnh.demo.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@SuppressWarnings("unused")
public class Bootstrap implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		
		//Load rootContext
		container.getServletRegistration("default").addMapping("/resource/*");
		
		AnnotationConfigWebApplicationContext rootContext=
				new AnnotationConfigWebApplicationContext();
		rootContext.register(RootContextConfig.class);
		container.addListener(new ContextLoaderListener(rootContext));
		
		AnnotationConfigWebApplicationContext servletContext=
				new AnnotationConfigWebApplicationContext();
		servletContext.register(ServletContextConfig.class);
		  ServletRegistration.Dynamic dispatcher = container.addServlet(
	                "springDispatcher", new DispatcherServlet(servletContext));
	        dispatcher.setLoadOnStartup(1);
	        dispatcher.addMapping("/");
	}

}
