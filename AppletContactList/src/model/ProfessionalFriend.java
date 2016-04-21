package model;
import java.io.Serializable;

public class ProfessionalFriend extends Acquaintance implements Serializable
{
	private String commonInterests;

	public ProfessionalFriend(Acquaintance a)
	{
		this.name=a.getName();
		this.emailAddress=a.getEmailAddress();
		this.mobileNumber=a.getMobileNumber();
	}
	
	public ProfessionalFriend()
	{
		
	}
	
	public String getCommonInterests() {
		return commonInterests;
	}

	public boolean setCommonInterests(String commonInterests) {
		if(commonInterests.length()<=100)
			{
			this.commonInterests = commonInterests;
			return true;
			}
		else
			{
			System.out.println("Please enter less than 100 chars");
			return false;
			}
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder=new StringBuilder("Name: ").append(name+"  ").append("Type: Professional Friend");
		return builder.toString();
	}
	

}
