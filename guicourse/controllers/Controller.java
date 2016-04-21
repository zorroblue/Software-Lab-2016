package controllers;

import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Locale;

import model.Course;
import model.DataBundle;
import model.Faculty;
import model.Participant;
import views.ErrorDialog;
import views.HomePage;


public class Controller {
	
	private static HashSet<Course> courses=new HashSet<Course>();
	private static  HashSet<Participant> participants=new HashSet<Participant>();
	private static HashSet<Faculty> faculty=new HashSet<Faculty>();
	private static MyFileIOManager fileWriter=new MyFileIOManager();
	private static String courseN;
	private static String partN; 
	private static String facN;
	public static String getFacultyName() {
		return facN;
	}

	public static void setFacultyName(String facN) {
		Controller.facN = facN;
	}

	public static String getParticipantName() {
		return partN;
	}

	public static void setParticipantName(String partN) {
		Controller.partN = partN;
	}

	public static String getCourseName() {
		return courseN;
	}

	public static void setCourseName(String courseName) {
		Controller.courseN = courseName;
	}

	public static void main(String[] args) throws InvocationTargetException, InterruptedException
	{
		//read from file
		try
		{
			DataBundle dataBundle=fileWriter.readFromFile();
			if(dataBundle!=null)
			{
				courses=dataBundle.getCourses();
				participants=dataBundle.getParticipants();
				faculty=dataBundle.getFaculty();
			}
		}
		catch(Exception e)
		{
			
		}
		
		EventQueue.invokeAndWait(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				HomePage homePage=new HomePage();
				homePage.setVisible(true);
				
			}
		});
	}
	
	  public static HashSet<Course> getCourses() {
		return courses;
	}

	public static void setCourses(HashSet<Course> courses) {
		Controller.courses = courses;
	}

	public static HashSet<Participant> getParticipants() {
		return participants;
	}

	public static void setParticipants(HashSet<Participant> participants) {
		Controller.participants = participants;
	}

	public static HashSet<Faculty> getFaculty() {
		return faculty;
	}

	public static void setFaculty(HashSet<Faculty> faculty) {
		Controller.faculty = faculty;
	}

	public static MyFileIOManager getFileWriter() {
		return fileWriter;
	}

	public static void setFileWriter(MyFileIOManager fileWriter) {
		Controller.fileWriter = fileWriter;
	}

	public Course addCourse(Course course) // add a new Course
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
	        	new ErrorDialog().invoke("Sorry cannot add course as IIT KGP only offers max 10 courses per year "+calendar2.get(Calendar.YEAR));
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
	            fileWriter.writeToFile(courses, faculty, participants);
	        }
	        return course;
	    }
	    

	    
	    public  Course getCourseByName(String name)
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
	        
	   public  Faculty getFacultyByName(Course c,String nameC)
	   {
	     //  Iterator iter=faculty.iterator();
	     //  System.out.println(iter.getClass().toString());
		   for(Faculty fac : c.getFaculty())
		   {
			   if(fac.getName().equals(nameC))
			   {
				   return fac;
			   }
		   }
	       return null;
	    }
	    public  Participant getParticipantByName(Course c,String name)
	    {
	    	System.out.println("Searching for "+name);
	        for(Participant p:c.getParticipants())
	        {
	            if(p.getName().equals(name))
	            {
	            	System.out.println(p.getName());
	                return p;
	            }
	        }
	        return null;
	    }
	            
	    public  ArrayList<String> getAllCourses()
	   {
	    	ArrayList<String> list=new ArrayList<String>();
	       if(courses.size()==0)
	            {
	                System.out.println("No course available");
	                return list;
	            }
	       Date today=new Date();
	       long durationInDays;
	       System.out.println("Courses Available (started 1 year back)\n");
	       for(Course c  : courses)
	       {
	    	   durationInDays=((long)(new Date().getTime()- c.getDate().getTime())/ (1000 * 60 * 60 * 24));
	    	   if(durationInDays<=365*5 && durationInDays>=0)
	          	   list.add(c.getCourseName());
	       }
	       return list;
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
	    
	    public  void displayParticipants(Course course)
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
	    public  void removeCourse(Course course)
	    {
	        courses.remove(course);
	        course=null;
	        fileWriter.writeToFile(courses, faculty, participants);
	        
	    }
	    
	  public Date validateDate(String dateName)
	  {
		  SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy",Locale.getDefault());
	       dateFormat.setLenient(false);
	       Calendar calendar=Calendar.getInstance();
	       try
	       {
	           calendar.setTime(dateFormat.parse(dateName));
	           Date date=calendar.getTime();
	           return date;
	        }
	        catch(Exception e)
	        {
	           new ErrorDialog().invoke("Enter date in dd/mm/yyyy format");
	            return null;
	        }
	  }
	   
	    
}


