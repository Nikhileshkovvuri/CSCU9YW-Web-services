package WebServicesAssignment.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Candidate {
	private String candidateNameBird;
	private String scientificName;
	private String descriptionOfCandidates;

	public Candidate() {
		candidateNameBird = "_";
		scientificName = "_";
		descriptionOfCandidates = "_";
	}

	/**
	 * This constructor will create a candidate for the vote.
	 *
	 * @param commonName     common name of the bird candidate.
	 * @param scientificName scientific name of the candidate bird is given.
	 * @param description    description of the candidate bird is given here.
	 */
	public Candidate(String candidateNameBird, String scientificName, String description) {
		this.candidateNameBird = candidateNameBird;
		this.scientificName = scientificName;
		this.descriptionOfCandidates = description;
	}

	// Copy constructor
	public Candidate(Candidate candidateBird) {
		this.candidateNameBird = candidateBird.candidateNameBird;
		this.scientificName = candidateBird.scientificName;
		this.descriptionOfCandidates = candidateBird.descriptionOfCandidates;
	}

	// Gets the Candidate Name
	@JsonProperty("CandidateName")
	public String getCandidateName() {
		return this.candidateNameBird;
	}

	// Sets the Candidate name
	@JsonProperty("CandidateName")
	public void setCandidateName(String candidateNameBird) {
		this.candidateNameBird = candidateNameBird;
	}

	// Gets the Scientific Name of the candidate
	@JsonProperty("scientificname")
	public String getScientificName() {
		return this.scientificName;
	}

	// Sets the Scientific Name of the candidate
	@JsonProperty("scientificname")
	public void setScientificName(String scientificname) {
		this.scientificName = scientificname;
	}

	// Gets the description of the candidate
	@JsonProperty("description")
	public String getDescription() {
		return this.descriptionOfCandidates;
	}

	// Sets the description of the candidate
	@JsonProperty("description")
	public void setDescription(String description) {
		this.descriptionOfCandidates = description;
	}

	@Override
	// returns string statement of description of candidate ,candidate name and
	// Scientific name
	public String toString() {
		return "Candidate{" + "Candidate Name=\"" + candidateNameBird + "\"," + "Scientific Name=\"" + scientificName
				+ "\"," + "Description=\"" + descriptionOfCandidates + "\"" + "}";
	}
}
