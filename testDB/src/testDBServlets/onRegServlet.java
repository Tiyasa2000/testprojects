package testDBServlets;
import testDBServices.insertDBdata;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/onRegServletURL")
public class onRegServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    
    public onRegServlet()
    {
        super();
       
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		System.out.println("Welcome to registration");
		String rnum=request.getParameter("rollnum");
		String name=request.getParameter("name");
		System.out.println(rnum);
		System.out.println(name);
		insertDBdata obj=new insertDBdata();
		boolean reg_done=obj.insertName(name,rnum);
		if(reg_done==true && obj.flagReg==0 )
			response.getWriter().print("<html><body>Your name is successfully registered.</body></html>");
		else if(reg_done==false && obj.flagReg==0 )
			response.getWriter().print("<html><body>Sorry, Your name could not be registered!! Please try again.</body></html>");		
		else if(reg_done==false && obj.flagReg==1)
			response.getWriter().print("<html><body>Sorry, You are already registered.</body></html>");
		
		
	}

}
