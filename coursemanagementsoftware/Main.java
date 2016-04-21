
/**
 * This is the main Controller
 * 
 * @author Rameshwar Bhaskaran
 * @rollNo 14CS30027
 */

import java.util.Scanner;
import java.awt.im.spi.InputMethodDescriptor;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

public class Main 
{
    //hashsets used to avoid duplicating objects
    
    
    private static HashSet<Course> courses;//courses
    private static HashSet<Participant> participants;  //participants involved in the program
    private static HashSet<Faculty> faculty; //faculty involved in the program
    
    private static MyFileIOManager fileWriter=new MyFileIOManager();
   
    
    public static void printMenu()
    {
        System.out.println("\n\n************MENU************\n");
        System.out.println("1.Create new course");
        System.out.println("2.Display all courses");
        System.out.println("3.Add faculty to existing courses");
        System.out.println("4.Add participants to existing courses");
        System.out.println("5.Print all participants for a particular course");
        System.out.println("6.Edit Course/Participant/Faculty");
        System.out.println("7.Delete Course/Participant/Faculty");
        System.out.println("8.Exit");
    }
        
    
    public static void main(String[] args)
    {
        System.out.println("**************************COURSE MANAGEMENT SOFTWARE*******************************************\n\n");
        try
        {
        	DataBundle dataBundle=fileWriter.readFromFile();
        	
        	courses=dataBundle.getCourses();
        	faculty=dataBundle.getFaculty();
        	participants=dataBundle.getParticipants();
        }
        catch(Exception e)
        {
            //e.printStackTrace();
        }
        if(courses==null)
        	courses=new HashSet<Course>();
        if(faculty==null)
        	faculty=new HashSet<Faculty>();
        if(participants==null)
        	participants=new HashSet<Participant>();
        boolean choice1 = true;
        
        while(choice1)
        {
            printMenu();
            Scanner scanner=new Scanner(System.in);
            System.out.print("*******************************\nEnter your choice: ");
            int choice;
            try
            {
                choice=scanner.nextInt();
            }
            catch(Exception e)
            {
                System.out.print("Enter a valid integer");
                continue;
            }
            switch(choice)
            {
                case 1:
                    {
                        System.out.println("*******************************\n");
                        Course newCourse=inputCourse(null);
                        if(newCourse==null)
                        {
                            System.out.println("Looks like a course of the same name has already been registered!");
                        }
                        else
                        {
                        addCourse(newCourse);
                        fileWriter.writeToFile(courses, faculty, participants);
                        }
                        break;
                    }
                case 2:
                {
                     System.out.println("*******************************\n");
                     displayAllCourses();
                     break;
                }
                case 3:
                {
                	System.out.print("Enter the name of the course you want to add faculty to  ");
                	scanner.nextLine();
                	String name=scanner.nextLine();
                	// System.out.println(name+ " is the name");
                	Course theCourse=getCourseByName(name);
                	if(theCourse!=null)
                	{
                		theCourse.addFaculty(inputFaculty(null));
                		break;
                	}
                	else
                	{
                		System.out.println("Looks like no such course exists or... try again!");
                	}
                    
                    fileWriter.writeToFile(courses, faculty, participants);
                     
                	break;
                }
                case 4:
                {
                       System.out.print("Enter the name of the course you want to add participant to  ");
                       while(true)
                       {
                           scanner.nextLine();
                           String name=scanner.nextLine();
                          // System.out.println(name+ " is the name");
                           Course theCourse=getCourseByName(name);
                           if(theCourse!=null)
                           {
                        	   Participant p=inputParticipant();
                               theCourse.addParticipant(p);
                               participants.add(p);
                               break;
                           }
                           else
                           {
                               System.out.println("Looks like no such course exists or... ");
                               break;
                           }
                       }
                       fileWriter.writeToFile(courses, faculty, participants);
                        break;
                }
                case 5:
                {
                	scanner.nextLine();
                	System.out.println("Enter the course name for which you want to see the participants..  ");
                	String name=scanner.nextLine();
                	//  System.out.println("The course is "+name+"xx1233323");
                	Course theCourse=getCourseByName(name);
                	if(theCourse!=null)
                	{
                		System.out.println("\n\n\nParticipants of course "+theCourse.getCourseName()+":");
                		displayParticipants(theCourse);
                		System.out.println("\n\n\n");
                		break;
                	}	
                	else
                	{
                		System.out.println("Looks like no such course exists...try again!");
                	}	
                    
                	break;
                }
                case 6: //editing
                {
                	scanner.nextLine();
                	System.out.println("Enter course name you want to edit?");
                    String theName=scanner.nextLine();
                    Course edittheCourse=getCourseByName(theName);
                    if(edittheCourse==null)
                        {
                    		System.out.println("There is no such course!");
                    		break;
                        }
                    System.out.println("Edit?\n\n1.Course details\n2.Faculty of course\n3.Participant of course");
                	System.out.print("Enter choice: ");
                	String choice2=scanner.nextLine();
                    if(choice2.equals("1"))
                    {
                        
                
                        	System.out.println(edittheCourse);
                        	//System.out.println("Enter the details to modify");
                        	//inputCourse(edittheCourse);
                        	editCourse(edittheCourse);
                           
                    }
                    else if(choice2.equals("2"))
                    {
                    	System.out.println("The faculty for course "+edittheCourse.getCourseName());
                    	if(edittheCourse.getFaculty().size()==0)
                    		{
                    		System.out.println("No faculty available!");
                    		break;	
                    		}
                    	for(Faculty f:edittheCourse.getFaculty())
                    		System.out.println(f.getName());
                        System.out.println("\nEnter faculty's name you want to edit?");
                        theName=scanner.nextLine();
                        	int flag1=0;
               
                        	for(int i=0;i<edittheCourse.getFaculty().size();i++)
                        	{
                        		Faculty f=edittheCourse.getFaculty().get(i);
                        		if(f.getName().equals(theName))
                        		{
                        			System.out.println("Enter details to modify : ");
                        			editFaculty(f);
                        			flag1=1;
                        			break;
                        		}
                        	}
                        	if(flag1==0)
                        		 System.out.println("There is no such faculty!");
                        }
                    
                    else if(choice2.equals("3"))
                     {
                    	System.out.println("The participants for course "+edittheCourse.getCourseName());
                    	if(edittheCourse.getParticipants().size()==0)
                    		{
                    		System.out.println("No participants available!");
                    		break;	
                    		}
                    	for(Participant f:edittheCourse.getParticipants())
                    		System.out.println(f.getName());
                        System.out.println("\nEnter participant's name you want to edit?");
                        theName=scanner.nextLine();
                        	int flag1=0;
               
                        	for(int i=0;i<edittheCourse.getParticipants().size();i++)
                        	{
                        		Participant f=edittheCourse.getParticipants().get(i);
                        		if(f.getName().equals(theName))
                        		{
                        			System.out.println("Enter details to modify : ");
                        			edittheCourse.getParticipants().set(i,inputParticipant());
                     
                        			//System.out.println("finished "+f.getName());
                        			flag1=1;
                        			break;
                        		}
                        	}
                        	if(flag1==0)
                        		 System.out.println("There is no such participant!");
                    }
                    else
                    {
                    	//System.out.println("You entered"+choice2+"abcc");
                    }
                    fileWriter.writeToFile(courses, faculty, participants);
                    break;
                }
                case 7:  //deleting 
                {
                	scanner.nextLine();
                	 System.out.println("Enter course name you want to delete fully/partially?");
                     String theName=scanner.nextLine();
                     Course deletetheCourse=getCourseByName(theName);
                     if(deletetheCourse==null)
                         {
                    	 	System.out.println("There is no such course!");
                    	 	break;
                         }
                    System.out.println("Delete?\n\n1.Course\n2.Faculty\n3.Participant");
                    String choice2=scanner.nextLine();
                    if(choice2.equals("1"))
                    {
                        removeCourse(deletetheCourse);
                    }
                    else if(choice2.equals("2"))
                    {
                    	System.out.println("Faculty for "+deletetheCourse.getCourseName());
                    	if(deletetheCourse.getFaculty().size()==0)
                    	{
                    		System.out.println("No faculty registered!");
                    		break;
                    	}
                    	for(Faculty f:deletetheCourse.getFaculty())
                    		System.out.println(f.getName());
                        System.out.println("Enter faculty's name you want to delete?");
                        theName=scanner.nextLine();
                        for(int i=0;i<deletetheCourse.getFaculty().size();i++)
                        {
                        	Faculty f=deletetheCourse.getFaculty().get(i);
                        	if(f.getName().equals(theName))
                        	{
                        		faculty.remove(f);
                        		deletetheCourse.getFaculty().remove(i);
                        	}
                        }
                    }
                    else if(choice2.equals("3"))
                     {
                    	
                    	System.out.println("Participants for "+deletetheCourse.getCourseName());
                    	if(deletetheCourse.getParticipants().size()==0)
                    	{
                    		System.out.println("No participannts registered!!");
                    		break;
                    	}
                    	for(Participant p:deletetheCourse.getParticipants())
                    		System.out.println(p.getName());
                        System.out.println("Enter participant's name you want to delete?");
                        theName=scanner.nextLine();
                        if(getParticipantByName(theName)==null)
                            System.out.println("There is no such participant!");
                        else
                        {
                             for(int i=0;i<deletetheCourse.getParticipants().size();i++)
                        	{
                        		Participant f=deletetheCourse.getParticipants().get(i);
                        		if(f.getName().equals(theName))
                        		{
                        			participants.remove(f);
                        			deletetheCourse.getParticipants().remove(i);
                       	 		}
                       	      	 }
                            	
                        }
                        
                     }
                    else
                    {
                    	System.out.println("Invalid choice!!");
                    }
                    fileWriter.writeToFile(courses, faculty, participants);
                   break;
                }
                
                case 8:
                {
                    choice1=false;
                    System.out.println("Exiting...");
                    fileWriter.writeToFile(courses, faculty, participants);
                    System.exit(0);
                    break;
                }
                default:
                {
                    System.out.println("Invalid choice..Try Again");
                }
                
            }
        }
        System.out.println("\n\n\n\n\n");
    }
    
    //editMethods
    
    public static void editFaculty(Faculty f) {
			Scanner scanner=new Scanner(System.in);
			System.out.print("EDIT \n\n1.Name\n2.Department\n3.Address\n4.Mobile number\n5.e-mail address\n\nEnter choice:");
			int choice=scanner.nextInt();
			scanner.nextLine();
			switch(choice)
			{
			case 1:
				System.out.print("Enter name :");
				f.setName(scanner.nextLine());
				break;
			case 2:
				System.out.print("Enter department: ");
				f.setDepartmentName(scanner.nextLine());
				break;
			case 3:
				System.out.print("Enter address: ");
				f.setAddress(scanner.nextLine());
				break;
			case 4:
				System.out.print("Enter mobile number: ");
				f.setMobileNumber(scanner.nextLine());
				break;
			case 5:
				System.out.print("Enter email address :");
				f.setEmailAddress(scanner.nextLine());
				break;
			default:
				System.out.println("Invalid choice!");
				break;
			}
    }
			
    public static void editParticipant(Participant p)
    {
    	Scanner scanner=new Scanner(System.in);
    	System.out.println("EDIT\n\n1.Name\n2.Address\n3.Mobile number\n4.Organization name\n5.E-mail address\n");
    	int choice=scanner.nextInt();
    	scanner.nextLine();
    	switch(choice)
    	{
    	case 1:
    		System.out.print("Enter name : ");
    		p.setName(scanner.nextLine());
    		break;
    	case 2:
    		System.out.print("Enter address: ");
    		p.setAddress(scanner.nextLine());
    		break;
    	case 3:
    		System.out.print("Enter mobile number: ");
    		p.setMobileNumber(scanner.nextLine());
    		break;
    	case 4:
    		System.out.print("Enter organisation name: ");
    		p.setOrganizationName(scanner.nextLine());
    		break;
    	case 5:
    		System.out.print("Enter email address: ");
    		p.setEmailAddress(scanner.nextLine());
    		break;
    	default:
    		System.out.println("Invalid choice!!");
    	}
    }

	public static void editCourse(Course course)
    {
    	Scanner scanner=new Scanner(System.in);
    	System.out.println("Edit?\n\n1. Name \n2. Fee\n3. Start date\n4. Duration\n5.Course Coordinator\n");
    	int choice=scanner.nextInt();
    	scanner.nextLine();
    	switch(choice)
    	{
    	case 1:
    		System.out.print("Enter name : ");
    		course.setCourseName(scanner.nextLine());
    		break;
    	case 2:
    		System.out.print("Enter fee : ");
    		course.setCourseFee(scanner.nextInt());
    		scanner.nextLine();
    		break;
    	case 3:
    		
    		 System.out.print("Enter start date in dd/mm/yyyy format");
    	       String dateName=scanner.nextLine();
    	       SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy",Locale.getDefault());
    	       dateFormat.setLenient(false);
    	       Calendar calendar=Calendar.getInstance();
    	       try
    	       {
    	           calendar.setTime(dateFormat.parse(dateName));
    	           Date date=calendar.getTime();
    	           course.setDate(date);
    	        }
    	        catch(Exception e)
    	        {
    	            System.out.println("Invalid Date!! Please enter in dd/mm/yyyy format!!");
    	        }
    	       break;
    	case 4:
    		System.out.print("Enter the duration: ");
    		try
    		{
    		course.setCourseDuration(scanner.nextInt());
    		scanner.nextLine();
    		}
    		catch(Exception e)
    		{
    			System.out.println("Invalid number");
    		}
    		default:
    			System.out.println("Invalid choice");
    			break;

    	case 5:
    		editFaculty(course.getCourseCoordinator());
    		break;
    	}
    }
                    
    //input methods
    
    private static Participant inputParticipant() {
        //name, address, mobileNumber, organizationName,emailAddress
        Scanner scanner=new Scanner(System.in);
        Participant participant =new Participant();
        System.out.print("Enter name : " );
        participant.setName(scanner.nextLine());
        System.out.print("Enter address : ");
        participant.setAddress(scanner.nextLine());
        System.out.print("Enter mobileNumber");
        participant.setMobileNumber(scanner.nextLine());
        System.out.print("Enter organisation name : ");
        participant.setOrganizationName(scanner.nextLine());
        System.out.print("Enter email address : ");
        participant.setOrganizationName(scanner.nextLine());
        return participant;
        
    }


    public static Course inputCourse(Course course)
   {
        Scanner scanner=new Scanner(System.in);
       
        
       System.out.println("Enter course name");
       
       String nameC=scanner.nextLine();
       if(getCourseByName(nameC)!=null && course==null)
           return null;
        
       if(course==null)
       	course=new Course();
       
       course.setCourseName(nameC);
        
       System.out.print("Enter date in dd/mm/yyyy format");
       boolean flag=true;
       while(flag)
       {
       String dateName=scanner.nextLine();
       SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy",Locale.getDefault());
       dateFormat.setLenient(false);
       Calendar calendar=Calendar.getInstance();
       try
       {
           calendar.setTime(dateFormat.parse(dateName));
           Date date=calendar.getTime();
           course.setDate(date);
           flag=false;
        }
        catch(Exception e)
        {
            System.out.println("Invalid Date!! Please enter in dd/mm/yyyy format!!");
        }
      }
      boolean flag1=true;
      System.out.print("Enter course fee ");
      while(flag1)    
      {
    	  try
          {
              course.setCourseFee(scanner.nextInt());
              
              flag1=false;
          }
          catch(Exception e )
          {
              System.out.println("Invalid..Try inputting Again");
              scanner.nextLine();
          }
      }
   
      System.out.print("Enter course duration in days");
     flag1=true;
     while(flag1){
      try
         {
    	  int val=scanner.nextInt();
    	  if(val>14)
    	  {
    		  System.out.print("Invalid input.Please enter less than 14 days max. :");
    		  scanner.nextLine();
    	  }
    	  else
    	  {
    		  course.setCourseDuration(val);
    		  flag1=false;
    	  }
         }		
          catch(Exception e)
          {
              System.out.println("Invalid input...Try again");
              scanner.nextLine();
              //e.printStackTrace();
          }
     }
      System.out.println("Enter the course coordinator ");
      char choice;
      scanner.nextLine();
      String fac=scanner.nextLine();    
	/*Faculty facCo=getFacultyByName(fac);
      while(true)
      {
      if(facCo==null)
      {
          System.out.println("No such faculty exists as per records....Adding new..)");

        
          try {
        
              Faculty newFaculty=inputFaculty(fac);
              course.setCourseCoordinator(newFaculty);
              faculty.add(newFaculty);
              System.out.println("Succesfully added coordinator");
              break;
            
          }
          catch (Exception e)
        {
            e.printStackTrace();
        }
        }
     else
      {
          course.setCourseCoordinator(facCo);
          break;
      }
    }*/
    
    flag1=true;
    while(flag1)
    {
     try {
        
              Faculty newFaculty=inputFaculty(fac);
              course.setCourseCoordinator(newFaculty);
              faculty.add(newFaculty);
              System.out.println("Succesfully added coordinator");
              flag1=false;
              break;
            
          }
          catch (Exception e)
        {
            System.out.println("Could not add coordinator...try again");
            
        }
    }
    
    System.out.println("You may add the faculty and students at a later time!");
    return course;
 }
 
 public static Faculty inputFaculty(String facultyName)
 {
     Scanner scanner=new Scanner(System.in);
     //Department to which he is affiliated, his name, address, mobile number, and e-mail address
     Faculty newFaculty=new Faculty();
     if(facultyName==null)
     {
         System.out.print("Enter the name");
         newFaculty.setName(scanner.nextLine());
     }
     else
     {
         newFaculty.setName(facultyName);
     }
     System.out.print("Enter the Department ");
     
     while(true)
     {
     try
     {
     newFaculty.setDepartmentName(scanner.nextLine());
     break;
     }
     catch(Exception e)
     {
         System.out.println("Invalid! try again!!");
    //   e.printStackTrace();
     }
     }
     System.out.print("Enter the mobile number");
     while(true)
     {
         try
         {
             newFaculty.setMobileNumber(scanner.nextLine());
             break;
         }
         catch(Exception e)
         {
             System.out.println("Invalid! try again!!");
            // e.printStackTrace(); 
         }
     }
     System.out.print("Enter the address");
     while(true)
     {
         try
         {
     
             newFaculty.setAddress(scanner.nextLine());
             break;
         }
         catch(Exception e)
         {
             System.out.println("Invalid! try again!!");
         }
     }
         
     
     System.out.print("Enter the email address");
     
     while(true)
     {
         try{
             newFaculty.setEmailAddress(scanner.nextLine());
             break;
         }
         catch(Exception e)
         {
             System.out.println("Invalid! try again!!");
         }
     }
         
     return newFaculty;
 }
     
     
        
      
    
      
    
    
    //Methods to create objects
   /* public Course createCourseObject() //returns a course object based on user input values
    {
        Scanner scanner=new Scanner(System.in);
     */   
    
    
    //Add methods
    public static Course addCourse(Course course) // add a new Course
    {
    	int count=0;
    	Calendar calendar2=new GregorianCalendar();
    	calendar2.setTime(course.getDate());
    	for(Course c: courses)
    	{
    		Calendar calendar1=new GregorianCalendar();
    		calendar1.setTime(c.getDate());
    		if(calendar1.get(Calendar.YEAR)==calendar2.get(Calendar.YEAR))
    		{
    			count++;
    			
    		}
    	}
    	
        if(count>10)
        {
        	System.out.println("Sorry cannot add course as IIT KGP only offers max 10 courses per year "+calendar2.get(Calendar.YEAR));
        }
        else
        {
            courses.add(course);
            //add to faculty and participants if not added before
            int i;
            for(i=0;i<course.getFaculty().size();i++)
            {
                faculty.add(course.getFaculty().get(i));
            }
            for(i=0;i<course.getParticipants().size();i++)
            {
                participants.add(course.getParticipants().get(i));
            }
//            
        }
        return course;
    }
    

    
    public static Course getCourseByName(String name)
    {
        //System.out.println("Received "+name);
        for(Course c : courses)
        {
            //System.out.println(c.getCourseName());
            if(c.getCourseName().equals(name))
                return c;
        }
        return null;
    }
        
   public static Faculty getFacultyByName(String nameC)
   {
     //  Iterator iter=faculty.iterator();
     //  System.out.println(iter.getClass().toString());
	   for(Faculty fac : faculty)
	   {
		   if(fac.getName().equals(nameC))
		   {
			   return fac;
		   }
	   }
       return null;
    }
    public static Participant getParticipantByName(String name)
    {
    	System.out.println("Searching for "+name);
        for(Participant p:participants)
        {
            if(p.getName().equals(name))
            {
            	System.out.println(p.getName());
                return p;
            }
        }
        return null;
    }
            
    public static void displayAllCourses()
   {
       if(courses.size()==0)
            {
                System.out.println("No course available");
                return;
            }
       Date today=new Date();
       long durationInDays;
       System.out.println("Courses Available (started 1 year back)\n");
       for(Course c  : courses)
       {
    	   durationInDays=((long)(new Date().getTime()- c.getDate().getTime())/ (1000 * 60 * 60 * 24));
    	   if(durationInDays<=365 && durationInDays>=0)
          	   System.out.println(c.getCourseName());
       }
    }
    
    public void addParticipant(Course course,Participant participant)
    {
        course.addParticipant(participant);
    }
    
    public void addFaculty(Course course,Faculty fac)
    {
    	course.addFaculty(fac);
    }
    
    //printing methods
    
    public static void displayParticipants(Course course)
    {
      //  System.out.println("Displaying the participants");
        ArrayList<Participant> part=course.getParticipants();
        if(part.size()==0)
            System.out.println("No participants have registered for this course!");
        else
        {
            for(Participant p:part)
            {
                System.out.println(p.getName());
            }
        }
    }  
    
    //delete methods
    public static void removeCourse(Course course)
    {
        courses.remove(course);
        course=null;
        fileWriter.writeToFile(courses, faculty, participants);
        
    }
}
    

    
    

