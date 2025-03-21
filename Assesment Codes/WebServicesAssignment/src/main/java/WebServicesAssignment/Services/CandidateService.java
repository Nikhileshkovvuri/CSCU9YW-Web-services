package WebServicesAssignment.Services;

import java.util.List;

import WebServicesAssignment.Model.*;


public interface CandidateService {
	// Adds a candidate to our database
    void addCandidate(Candidate candidateBird);

    // Gets a candidate from our database
    Candidate getCandidate(String candidateNameBird);

    // Gets a list of candidates
    List<Candidate> getCandidate();
    

}
