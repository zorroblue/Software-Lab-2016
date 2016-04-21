package views;

public class DisplayCourse extends DisplayStuff{
	
	public  DisplayCourse() {
		// TODO Auto-generated constructor stub
		populateTextArea();
	}
	@Override
	public void populateTextArea() {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder=new StringBuilder();
		int i=0;
		for(String s: c.getAllCourses())
		{
			stringBuilder.append(++i+". "+s+"\n");
		}
		textArea.setText(stringBuilder.toString());
		
	}

}
