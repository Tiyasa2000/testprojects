package testDBServices;
import testDBbeans.student;

import testDBDAO.afterClickDAO;

public class getDBdata 
{
	public String getName(String rollnum)
	{
		String name="";
		
		afterClickDAO obj=new afterClickDAO();
		student stuarr[]=obj.getNameFromDB(rollnum);
		
		for(int i=0;i<stuarr.length;i++)
		{
			if(Integer.parseInt(rollnum)==stuarr[i].getID())
			{
				name=stuarr[i].getName();
				break;
			}
		}
		return name;
	}

}
