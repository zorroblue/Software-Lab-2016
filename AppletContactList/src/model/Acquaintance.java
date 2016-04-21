package model;
import java.io.Serializable;

public class Acquaintance  implements Serializable
{
	

	protected String name,mobileNumber,emailAddress; //accessibility to derived classes
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public boolean validateString(String s)
	{
		if(s.length()<=100)
			return true;
		return false;
	}
	
}
