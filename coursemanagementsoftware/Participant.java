import java.io.Serializable;

/**
 * Write a description of class Participant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Participant implements Serializable
{
    String name, address, mobileNumber, organizationName,emailAddress;
    
    

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		public String getOrganizationName() {
			return organizationName;
		}

		public void setOrganizationName(String organizationName) {
			this.organizationName = organizationName;
		}

		public String getEmailAddress() {
			return emailAddress;
		}

		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}
		
		@Override
		public String toString()
		{
		    return new StringBuilder("Name: ").append(name).append("\nAddress: ").append(address+"\n").toString();
		}
}
