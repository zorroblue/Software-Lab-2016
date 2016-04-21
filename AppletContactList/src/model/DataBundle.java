package model;
import java.io.Serializable;
import java.util.HashSet;

public class DataBundle implements Serializable //Is a bundle of acquaintances 
{
	private HashSet<Relative> relatives;
	private HashSet<PersonalFriend> personalFriends;
	private HashSet<ProfessionalFriend> professionalFriends;
	private HashSet<CasualFriend> casualFriends;
	
	public DataBundle(HashSet<Relative> relatives,HashSet<PersonalFriend> personalFriends,HashSet<ProfessionalFriend> professionalFriends,HashSet<CasualFriend> casualFriends)
	{
		this.relatives=relatives;
		this.personalFriends=personalFriends;
		this.professionalFriends=professionalFriends;
		this.casualFriends=casualFriends;
	}
	public HashSet<Relative> getRelatives() {
		return relatives;
	}
	public void setRelatives(HashSet<Relative> relatives) {
		this.relatives = relatives;
	}
	public HashSet<PersonalFriend> getPersonalFriends() {
		return personalFriends;
	}
	public void setPersonalFriends(HashSet<PersonalFriend> personalFriends) {
		this.personalFriends = personalFriends;
	}
	public HashSet<ProfessionalFriend> getProfessionalFriends() {
		return professionalFriends;
	}
	public void setProfessionalFriends(HashSet<ProfessionalFriend> professionalFriends) {
		this.professionalFriends = professionalFriends;
	}
	public HashSet<CasualFriend> getCasualFriends() {
		return casualFriends;
	}
	public void setCasualFriends(HashSet<CasualFriend> casualFriends) {
		this.casualFriends = casualFriends;
	}
	
	
}
