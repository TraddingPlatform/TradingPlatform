package org.citi.training.TradingPlatform.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.jersey.spi.container.servlet.ServletContainer;

public class StartServer {
	public static void main( String[] args ) throws Exception
    {
		Server server=new Server(8080);
    	ServletHolder servlet = new ServletHolder(ServletContainer.class);
    	servlet.setInitParameter("com.sun.jersey.config.property.resourceConfigClass", 
    			"com.sun.jersey.api.core.PackagesResourceConfig");
        servlet.setInitParameter("com.sun.jersey.config.property.packages", 
        		"org.citi.training.TradingPlatform.facade");
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setContextPath("/");
        handler.addServlet(servlet, "/*");
        server.setHandler(handler);
        server.start();
        server.join();
    }
}
