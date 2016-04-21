/**
 * Write a description of class Serializer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.io.*;

public class MyFileIOManager implements Serializable //writes the data and reads from the file
{
    public void  writeToFile(HashSet<Course> courses,HashSet<Faculty> faculty,HashSet<Participant> participants)
    {
        try
        {
            File file=new File("data.txt");
            FileOutputStream fout = new FileOutputStream(file); //overwrite
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            DataBundle dataBundle=new DataBundle();
            dataBundle.setCourses(courses);
            dataBundle.setFaculty(faculty);
            dataBundle.setParticipants(participants);
            try
            {
            oos.writeObject(dataBundle);
            }
            catch(Exception e)
            {
            	e.printStackTrace();
            	System.out.println("Not able to print");
            }
           oos.flush();
            oos.close();
        }
        catch(Exception e)
        {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
    public DataBundle readFromFile()
    {
    	 String fileName="data.txt";
         try
         {
         ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fileName));
         DataBundle dataBundle=(DataBundle) ois.readObject();
         ois.close();
         return dataBundle;
     }
     catch(Exception e)
     {
        // e.printStackTrace();
     }
         return null;
    }
}