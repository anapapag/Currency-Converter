

 import java.io.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.lang.String;
import java.lang.*;
import java.net.*;

public class ISCL implements ServletContextListener {

      	
    public void contextInitialized(ServletContextEvent event) {
        
        System.out.println("test");
        
        ServletContext sc = event.getServletContext();
        
        String redirectl = sc.getInitParameter("redirectLink");
	
	Redl rl = new Redl(redirectl);
		
	sc.setAttribute("redirect", rl);

    }

    public void contextDestroyed(ServletContextEvent event) {
	}
    
}