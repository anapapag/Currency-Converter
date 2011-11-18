
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class InfoServlet extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
														throws IOException, ServletException  {

       
        response.setContentType("text/html");
	PrintWriter out = response.getWriter();	
	Redl redirect = (Redl) getServletContext().getAttribute("redirect");
        response.sendRedirect(redirect.getRedlink());		
       //out.println("tasos");
            
           
    
    }

    
    

    
}