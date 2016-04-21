package model;
import java.io.Serializable;
import java.util.Date;



public class Relative extends Acquaintance implements Serializable
{
	Date birthday,lastMet;

	public Relative(Acquaintance a)
	{
		this.name=a.getName();
		this.emailAddress=a.getEmailAddress();
		this.mobileNumber=a.getMobileNumber();
	}
	
	public Relative()
	{
		
	}
	
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getLastMet() {
		return lastMet;
	}

	public void setLastMet(Date lastMet) {
		this.lastMet = lastMet;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder=new StringBuilder("Name: ").append(name+"  ").append("Type: Relative");
		return builder.toString();
	}

}
