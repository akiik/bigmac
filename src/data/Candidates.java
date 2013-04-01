package data;

import java.util.ArrayList;
import java.util.List;

public class Candidates {
	java.util.List<Candidate> candidates= new ArrayList<Candidate>();

	public Candidates(List<Candidate> kandidaadid) {
		super();
		this.candidates = kandidaadid;
	}

	public java.util.List<Candidate> getCandidates() {
		return candidates;
	}

	public void setKandidaadid(java.util.List<Candidate> kandidaadid) {
		this.candidates = kandidaadid;
	}
	
}
