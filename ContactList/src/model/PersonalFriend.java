package model;
import java.io.Serializable;
import java.util.Date;

public class PersonalFriend extends Acquaintance implements Serializable
{
	private String context,event;
	private Date dateAcquainted;

	public PersonalFriend()
	{
		
	}
	
	public PersonalFriend(Acquaintance a)
	{
		this.name=a.name;
		this.emailAddress=a.emailAddress;
		this.mobileNumber=a.mobileNumber;
	}
	
	public String getContext() {
		return context;
	}
	public boolean setContext(String context) {
		if(context.length()<=100)
		{
			this.context = context;
			return true;
		}
		else
		{
			System.out.print("Please enter less than 100 chars(limit): ");
			return false;
		}
	}
	public String getEvent() {
		return event;
	}
	public boolean setEvent(String event) {
		if(event.length()<=100)
		{
			this.event = event;
			return true;
		}
		else
		{
			System.out.print("Please enter less than 100 chars(limit): ");
			return false;
		}
		
	}
	public Date getDateAcquainted() {
		return dateAcquainted;
	}
	public void setDateAcquainted(Date dateAcquainted) {
		this.dateAcquainted = dateAcquainted;
	}
	@Override
	public String toString()
	{
		StringBuilder builder=new StringBuilder("Name: ").append(name+"  ").append("Type: Personal Friend");
		return builder.toString();
	}
}
