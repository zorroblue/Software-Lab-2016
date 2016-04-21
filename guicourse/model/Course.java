
/**
 * This is the class which contains the needed properties of a course
 * 
 * @author Rameshwar
 * @rollNo 14CS30027
 */
package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Course implements Serializable
{
     private String courseName;
       private Date date;
       private Integer courseFee;
       private Integer courseDuration;  //in days
       Faculty courseCoordinator;
       ArrayList<Faculty> teachingFaculty=new ArrayList<Faculty>();
       ArrayList<Participant> courseParticipants=new ArrayList<Participant>();
       
       public Course()
       {
       
       }
       
       public Course(String courseName,Date date,Integer courseFee,Integer courseDuration,Faculty courseCoordinator,ArrayList<Faculty> teachingFaculty,ArrayList<Participant> courseParticipants)
       {
           this.courseName=courseName;
           this.date=date;
           this.courseFee=courseFee;
           this.courseDuration=courseDuration;
           this.courseCoordinator=courseCoordinator;
           this.teachingFaculty=teachingFaculty;
           this.courseParticipants=courseParticipants;
        }        
       
    @Override
    public String toString() //customise the printing of the object
    {
        StringBuilder ans= new StringBuilder("Course: ").append(courseName).append("\nDate of start: ").append(date.toString()+"\nFaculty:\n");
        for(Faculty f:teachingFaculty)
        {
        	ans.append(f.getName()+"\n");
        }
        ans.append("Participants:\n");
        for(Participant p:courseParticipants)
        {
        	ans.append(p.getName()+"\n");
        }
        return ans.toString();
    }
    
        
    public ArrayList<Faculty> getFaculty()
    {
        return this.teachingFaculty;
    }
    
    public void addFaculty(Faculty faculty)
    {
        if(this.teachingFaculty.size()<5)
            this.teachingFaculty.add(faculty);
        else
            System.out.println("Cannot add faculty! Course size already full!");
    }
    public void deleteFaculty(Faculty faculty)
    {
        this.teachingFaculty.remove(faculty);
    }
    
    public ArrayList<Participant> getParticipants()
    {
        return this.courseParticipants;
    }
    
    public void addParticipant(Participant participant)
    {
        if(this.courseParticipants.size()<5)
            this.courseParticipants.add(participant);
        else
            System.out.println("Cannot add participant! Course size already full!");
    }
    public void deleteParticipant(Participant participant)
    {
        this.courseParticipants.remove(participant);
    }
    
       
    public String getCourseName() {
        return courseName;
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Integer getCourseFee() {
        return courseFee;
    }
    public void setCourseFee(Integer courseFee) {
        this.courseFee = courseFee;
    }
    public Integer getCourseDuration() {
        return courseDuration;
    }
    public void setCourseDuration(Integer courseDuration) {
        if(courseDuration <=14)
            this.courseDuration = courseDuration;
        else    //ERROR
            System.out.println("Not possible");
        
    }
    public Faculty getCourseCoordinator() {
        return courseCoordinator;
    }
    public void setCourseCoordinator(Faculty courseCoordinator) {
        this.courseCoordinator = courseCoordinator;
    }

}

