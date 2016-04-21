package controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;

import javax.naming.Context;

import model.CasualFriend;
import model.DataBundle;
import model.PersonalFriend;
import model.ProfessionalFriend;
import model.Relative;
import view.MainFrame;

public class Controller {

	private static HashSet<Relative> relatives=new HashSet<Relative>();
	private static HashSet<PersonalFriend> personalFriends=new HashSet<PersonalFriend>();
	private static HashSet<ProfessionalFriend> professionalFriends=new HashSet<ProfessionalFriend>();
	private static HashSet<CasualFriend> casualFriends=new HashSet<CasualFriend>();
	private static MyFileIOManager fileWriter=new MyFileIOManager();
	private static MainFrame appletContext; 
	
	public MainFrame getAppletContext() {
		return appletContext;
	}

	public void setAppletContext(MainFrame appletContext) {
		this.appletContext = appletContext;
	}

	public void readTheFile()
	{
		DataBundle dataBundle=fileWriter.readFromFile();
		if(dataBundle!=null)
		{
			relatives=dataBundle.getRelatives();
			personalFriends=dataBundle.getPersonalFriends();
			professionalFriends=dataBundle.getProfessionalFriends();
			casualFriends=dataBundle.getCasualFriends();	
		}
	}
	
	public static void writeToFile()
	{
		DataBundle dataBundle=new DataBundle(relatives, personalFriends, professionalFriends, casualFriends);
		fileWriter.writeToFile(dataBundle);
	}
	public static void initialiseApplication()
	{
		//read from file
		MyFileIOManager fileWriter=new MyFileIOManager();
		DataBundle dataBundle=fileWriter.readFromFile();
		if(dataBundle==null)
			return; //no data saved
		else
		{
			relatives=dataBundle.getRelatives();
			personalFriends=dataBundle.getPersonalFriends();
			professionalFriends=dataBundle.getProfessionalFriends();
			casualFriends=dataBundle.getCasualFriends();
		}
				
	}
	
	public static Date parseAndGetDate(String dateName)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date date=null;
		    	
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy",Locale.getDefault());
    	dateFormat.setLenient(false);
    	Calendar calendar=Calendar.getInstance();
    	try
    	{
    		calendar.setTime(dateFormat.parse(dateName));
	        date=calendar.getTime();
	        return date;
	    }
    	catch(Exception e)
        {
    		return null;
        }
    }
		    
		
		
	
	
	

	public static HashSet<Relative> getRelatives() {
		return relatives;
	}

	public static void setRelatives(HashSet<Relative> relatives) {
		Controller.relatives = relatives;
	}

	public static HashSet<PersonalFriend> getPersonalFriends() {
		return personalFriends;
	}

	public static void setPersonalFriends(HashSet<PersonalFriend> personalFriends) {
		Controller.personalFriends = personalFriends;
	}

	public static HashSet<ProfessionalFriend> getProfessionalFriends() {
		return professionalFriends;
	}

	public static void setProfessionalFriends(HashSet<ProfessionalFriend> professionalFriends) {
		Controller.professionalFriends = professionalFriends;
	}

	public static HashSet<CasualFriend> getCasualFriends() {
		return casualFriends;
	}

	public static void setCasualFriends(HashSet<CasualFriend> casualFriends) {
		Controller.casualFriends = casualFriends;
	}

	public static void deleteAcquaintance(int choice)
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the name of the acquaintance you want to delete: ");
		String name=scanner.nextLine();
		switch(choice)
		{
		case 1:
		{
			Relative p=getRelativeByName(name);
			if(p==null)
				System.out.println("No such name exists!");
			else
			{
				if(relatives.remove(p))
					System.out.println("Deleted "+name);
				else
					System.out.println("No such name exists");
			}
			break;
		}
		case 2:
		{
			//delete personal contact
			PersonalFriend p=getPersonalFriendByName(name);
			if(p==null)
				System.out.println("No such name exists!");
			else
			{
				if(personalFriends.remove(p))
					System.out.println("Deleted "+name);
				else
					System.out.println("No such name exists");
			}
			break;
		}
		case 3:
		{
			ProfessionalFriend p=getProfessionalFriendByName(name);
			if(p==null)
				System.out.println("No such name exists!");
			else
			{
				if(professionalFriends.remove(p))
					System.out.println("Deleted "+name);
				else
					System.out.println("No such name exists");
			}
			break;
		}
		case 4:
		{
			CasualFriend p=getCasualFriendByName(name);
			if(p==null)
				System.out.println("No such name exists!");
			else
			{
				if(personalFriends.remove(p))
					System.out.println("Deleted "+name);
				else
					System.out.println("No such name exists");
			}
			break;
		}
		case 5:
		{
			//general delete
			Relative a=getRelativeByName(name);
			PersonalFriend b=getPersonalFriendByName(name);
			ProfessionalFriend c=getProfessionalFriendByName(name);
			CasualFriend d=getCasualFriendByName(name);
			if(a==null && b==null && c==null && d==null)
			{
				System.out.println("No such name found in database!");
			}
			else
			{
				if(a!=null)
					relatives.remove(a);
				else if(b!=null)
					personalFriends.remove(b);
				else if(c!=null)
					professionalFriends.remove(c);
				else 
					casualFriends.remove(d);
				System.out.println("Deleted acquaintance!");
			}
			break;
		}
		default:
		{
			System.out.println("Invalid choice! Try again!");
			break;
		}
		}
		writeToFile();
	}
	
	public static DataBundle makeBundle()
	{
		return new DataBundle(relatives,personalFriends,professionalFriends,casualFriends);
	}
	
	
	public static PersonalFriend getPersonalFriendByName(String name)
	{
		for(PersonalFriend p: personalFriends)
		{
			if(p.getName().equals(name))
			{
				return p;
			}
		}
		return null;
	}
	
	public static ProfessionalFriend getProfessionalFriendByName(String name)
	{
		for(ProfessionalFriend p: professionalFriends)
		{
			if(p.getName().equals(name))
			{
				return p;
			}
		}
		return null;
	}
	
	public static CasualFriend getCasualFriendByName(String name)
	{
		for(CasualFriend p: casualFriends)
		{
			if(p.getName().equals(name))
			{
				return p;
			}
		}
		return null;
	}
	
	public static Relative getRelativeByName(String name)
	{
		for(Relative p: relatives)
		{
			if(p.getName().equals(name))
			{
				return p;
			}
		}
		return null;
	}
}
