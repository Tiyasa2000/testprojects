package testDBServices;
import testDBDAO.afterClickDAO;
import testDBDAO.afterRegDAO;
import testDBbeans.student;

public class insertDBdata 
{
	public int flagReg=0;
	public boolean insertName(String name,String roll)
	{
		//int flagReg=0;
		boolean p=false;
		afterClickDAO obj1=new afterClickDAO();
		student stuarr[]=obj1.getNameFromDB(roll);
		try 
		{
			for(int i=0;i<stuarr.length;i++)
			{
				if(Integer.parseInt(roll)==stuarr[i].getID())
				{
					flagReg=1;
					break;
				}
			}
			if(flagReg==0)
			{
				afterRegDAO obj=new afterRegDAO();
				p=obj.insertNameIntoDB(name,roll);
				return p;
			}
			else
				return p;
		}
		catch(Exception e)
		{
			return p;
		}
	}
}
