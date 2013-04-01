package data;

public class Candidate {
	  private int id; 
	  private Person person;
	  private Party party;
	  private Region region;
	public Candidate(int id, Person person, Party party, Region region) {
		super();
		this.id = id;
		this.person = person;
		this.party = party;
		this.region = region;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Party getParty() {
		return party;
	}
	public void setParty(Party party) {
		this.party = party;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	
	

	  
}
