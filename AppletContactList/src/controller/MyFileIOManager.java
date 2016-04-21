package controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;

import model.DataBundle;

public class MyFileIOManager implements Serializable //takes care of file operations 
{	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4749540203158945034L;

	public void writeToFile(DataBundle dataBundle)
	{
		try
		{
		//	File file=new File("data.txt");
			URL is = MyFileIOManager.class.getResource("/data.txt");
			
			FileOutputStream fileOutputStream=new FileOutputStream(is.getFile());
			ObjectOutputStream oos=new ObjectOutputStream(fileOutputStream);
			try
			{
				oos.writeObject(dataBundle);
			}
			catch(Exception e)
			{
			//	System.out.println("Not able to print");
			}
			oos.flush();
			oos.close();
		}			
		catch(Exception e)
		{
			System.out.println("Not able to print");
		}
	}
	
	public DataBundle readFromFile()
	{
		try
		{
			//File file=new File("data.txt");
			
			URL is = MyFileIOManager.class.getResource("/data.txt");
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(is.getFile()));
			
			
			DataBundle dataBundle=(DataBundle) ois.readObject();
			ois.close();
			return dataBundle;
		}
		catch(Exception e)
		{
			System.out.println("Could not read from file!");
		}
		return null;
	}
}