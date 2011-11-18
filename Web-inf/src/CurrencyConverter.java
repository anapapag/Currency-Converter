/* CurrencyConverter.java: A servlet to convert dollars to euros */
/* compile with -classpath <CATALINA_HOME>\common\lib\servlet-api.jar */
import java.io.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.lang.String;
import java.lang.*;
import java.net.*;

public class CurrencyConverter extends HttpServlet {
    public void doGet(HttpServletRequest req,HttpServletResponse res)
              throws ServletException, IOException {
           	res.setContentType("text/html");
			
			
           	PrintWriter out = res.getWriter();
           	out.println("<html>");
           	out.println("<head><title>Currency Conversion</title></head>");
           	out.println("<body>");
						String from = req.getParameter("from");
						String  to = req.getParameter("to");
						String amount = req.getParameter("amount");
						String   amount1 = amount.replace( ',', '.' );
						double d = Double.parseDouble(amount1);
					
						
           	try {
        	 
        	   
        	   URL google = new URL("http://www.google.com/ig/calculator?hl=en&q="+d+from+"=?"+to);
               URLConnection yc = google.openConnection();
               BufferedReader in = new BufferedReader(
                                       new InputStreamReader(
                                       yc.getInputStream()));
               String inputLine="";
               String mydata="";

               while ((inputLine= in.readLine()) != null) {
               	mydata+=inputLine;
               };
               String delim="[\"]";
               String[] tokens = mydata.split(delim);
							
							
							tokens[1]=tokens[1].replaceAll("?","");
							
							tokens[3]=tokens[3].replaceAll("?","");
							out.println("<big> "+tokens[1]+" = "+tokens[3]+" </BIG>");
               in.close();
        	   
               
            }
            catch (NumberFormatException e) {
            	out.println("Bad number format");
            }
            out.println("</body></html>");
       }
}

