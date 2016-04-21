package model;
import java.io.Serializable;
import java.util.Date;

public class CasualFriend extends Acquaintance implements Serializable
{
	Date metWhen;
	String metWhere,metCircumstance;
	String other;
	
	public CasualFriend(Acquaintance a)
	{
		this.name=a.getName();
		this.emailAddress=a.getEmailAddress();
		this.mobileNumber=a.getMobileNumber();
	}
	
	public CasualFriend()
	{
		
	}
	
	public Date getMetWhen() {
		return metWhen;
	}
	public void setMetWhen(Date metWhen) {
		this.metWhen = metWhen;
	}
	public String getMetWhere() {
		return metWhere;
	}
	public boolean setMetWhere(String metWhere) {
		if(metWhere.length()<=100)
		{
		this.metWhere = metWhere;
		return true;
		}
		else
		{
			System.out.print("Please enter less than 100 chars(limit): ");
			return false;
		}
	}
	public String getMetCircumstance() {
		return metCircumstance;
	}
	public boolean setMetCircumstance(String metCircumstance) {
		if(metCircumstance.length()<=100)
		{
			this.metCircumstance = metCircumstance;
			return true;
		}
		else
		{
			System.out.print("Please enter less than 100 chars(limit): ");
			return false;
		}
	}
	public String getOther() {
		return other;
	}
	public boolean setOther(String other) {
		if(other.length()<=100)
		{
			this.other = other;
			return true;
		}
		else
		{
			System.out.print("Please enter less than 100 chars(limit): ");
			return false;
		}
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder=new StringBuilder("Name: ").append(name+"  ").append("Type: Casual Friend");
		return builder.toString();
	}
}
