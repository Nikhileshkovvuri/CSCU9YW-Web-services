package WebServicesAssignment.Services;

import java.util.List;


import WebServicesAssignment.Model.*;



public interface VoteService {
	// Adds a vote to the database, or overwrites the existing one.
    void addVote(Vote memberVote);
    

    //True will be returned if there is a vote
    default boolean hasVote(String candidateNameBird) {
        return getVote(candidateNameBird) != null;
    }

    // Returns a vote; null if there is none.
    Vote getVote(String candidateNameBird);
    
    Candidate Post(String membershipNumber, String candidateNameBird);
    void Remove(String membershipNumber, String candidateNameBird);	

    

    // Returns a list of all votes in the database.
    List<Vote> getAllVotes();


	void countVote();

    // Removes the welcome for language lang from the database.
    

}
