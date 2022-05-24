//package

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class RunManager {
	
	
	public static void main(String[] args) {
		
		try {
			start();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
  
  // start 
	public static void start() throws Exception {
		// port
		Server server = new Server(8080);
		// context path
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		server.setHandler(context);
		
		context.addServlet(new ServletHolder(new MessageServlet()), "/");
		
		server.start();
		server.join();
		
//		MessageService.messageService();
				
	}
}
