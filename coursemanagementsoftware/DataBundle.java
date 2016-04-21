import java.io.Serializable;
import java.util.HashSet;

public class DataBundle implements Serializable//contains HashSets of course,participants,faculty for easier access (single object read and write)
{
	HashSet<Course> courses;
	HashSet<Faculty> faculty;
	HashSet<Participant> participants;
	
	public HashSet<Course> getCourses() {
		return courses;
	}
	public void setCourses(HashSet<Course> courses) {
		this.courses = courses;
	}
	public HashSet<Faculty> getFaculty() {
		return faculty;
	}
	public void setFaculty(HashSet<Faculty> faculty) {
		this.faculty = faculty;
	}
	public HashSet<Participant> getParticipants() {
		return participants;
	}
	public void setParticipants(HashSet<Participant> participants) {
		this.participants = participants;
	}
	
	

}
