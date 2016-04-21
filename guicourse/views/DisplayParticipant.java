package views;

import java.util.ArrayList;

import model.Participant;

//Generates the list of participants for a particular course
public class DisplayParticipant extends DisplayStuff {

	String theCourseName;
	
	public  DisplayParticipant(String theCourseName) {
		// TODO Auto-generated constructor stub
		this.theCourseName=theCourseName;
	//	System.out.println("DEBUG1 :"+theCourseName);
		populateTextArea();
	}
	@Override
	public void populateTextArea() {
		// TODO Auto-generated method stub
		System.out.println("DEBUG 0");
		if(c.getCourseByName(theCourseName)==null)
		{
			textArea.setText("No such course exists");
			return;
		}
		ArrayList<Participant> list=c.getCourseByName(theCourseName).getParticipants();
		StringBuilder stringBuilder=new StringBuilder("");
		if(list.size()==0)
		{
			textArea.setText("No participants for this course!");
		}
		else
		{
			int k=0;
			for(Participant p: list)
			{
				stringBuilder.append(++k+". "+p.getName()+"\n");
			}
			textArea.setText(stringBuilder.toString());
		}
		
	}

}
