
package testDBServlets;

import testDBServices.getDBdata;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/onClickServletURL")
public class onClickServlet extends HttpServlet
 {
	private static final long serialVersionUID = 1L;
       
    public onClickServlet()
    {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String rnum=request.getParameter("rollnum");
				
		getDBdata obj1=new getDBdata();
		
		String name=obj1.getName(rnum);
		
		if(name=="")
			response.getWriter().print("<html><body>Your name is not registered.</body></html>");
		else
			response.getWriter().print("<html><body>Your name is "+name+".</body></html>");		
	}

}
