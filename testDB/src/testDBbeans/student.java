package testDBbeans;

@SuppressWarnings("serial")
public class student implements java.io.Serializable
{
	private int id;
	private String name;
	public student()
	{
	}
	public void setID(int id)
	{
		this.id=id;
	}
	public int getID()
	{
		return id;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	
}

