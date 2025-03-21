package WebServicesAssignment.Services;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import WebServicesAssignment.Model.*;
import WebServicesAssignment.Services.*;

@Component
public class CandidateServiceImpl implements CandidateService {

	Map<String, Candidate> canDataBase;

	public CandidateServiceImpl() {
		canDataBase = new HashMap<>();
	}

	// Adds candidate to the database
	public void addCandidate(Candidate candidateBird) {
		if (candidateBird != null && candidateBird.getScientificName() != null) {

			candidateBird = new Candidate(candidateBird);
			canDataBase.put(candidateBird.getCandidateName(), candidateBird);
		}
	}

	// Gets a candidate's common name from our database
	public Candidate getCandidate(String candidateNameBird) {
		Candidate candidateBird = canDataBase.get(candidateNameBird);

		candidateBird = new Candidate(candidateBird);

		return candidateBird;
	}

	// Gets a list of all candidates
	public List<Candidate> getCandidate() {
		ArrayList<Candidate> list = new ArrayList<>();
		canDataBase.values().forEach(candidateBird -> {
			list.add(new Candidate(candidateBird));
		});
		return list;
	}

}
