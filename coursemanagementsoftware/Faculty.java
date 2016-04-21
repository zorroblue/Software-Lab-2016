import java.io.Serializable;

/**
 * This class represents a real world faculty
 * 
 * @author Rameshwar Bhaskaran
 * @rollNo 14CS30027
 */
public class Faculty implements Serializable
	{
		
	    String departmentName,name,address,mobileNumber,emailAddress;

		public String getDepartmentName() {
			return departmentName;
		}

		public void setDepartmentName(String departmentName) {
			this.departmentName = departmentName;
		}

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

		public String getEmailAddress() {
			return emailAddress;
		}

		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}
		
		@Override
		public String toString() //customise printing
		{
		    return new StringBuilder("Faculty Name: ").append(name).append("\nDepartment Name : ").append(departmentName+"\n").toString();
		}
	}
