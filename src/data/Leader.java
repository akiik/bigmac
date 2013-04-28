package data;

public class Leader {
	private String party;
	private Float score;
	
	public Leader(String party, Float score){
		this.party=party;
		this.score=score;
		
	}
	public String getParty() {
		return party;
	}
	public void setId(String party) {
		this.party = party;
	}
	public float getScore() {
		return score;
	}
	public void setScore(Float score) {
		this.score = score;
	}
	
}