package WebServicesAssignment.Services;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import WebServicesAssignment.Model.*;

@Component
public class VoteServiceImpl implements VoteService {

	Map<String, Vote> database;

	public VoteServiceImpl() {
		database = new HashMap<>();
	}

	// Here the ballot is added to the database or overwrite an existing one
	public void addVote(Vote memberVote) {
		if (memberVote != null && memberVote.getCandidate() != null) {
			memberVote = new Vote(memberVote);
			database.put(memberVote.getCandidate().getCandidateName(), memberVote);
		}
	}

	public Vote getVote(String candidateNameBird) {
		Vote vote = database.get(candidateNameBird);
		return vote;
	}

	// Here the list of all votes/ballots returned to the database.
	public List<Vote> getAllVotes() {
		List<Vote> list = new ArrayList<Vote>();

		database.values().forEach(vote -> {
			list.add(new Vote(vote));
		});
		return list;
	}

	public Candidate Post(String membershipNumber, String candidateNameBird) {

		for (Vote vote: database.values()) {

			if (vote.ReturnMembershipNum().contains(membershipNumber)) {
				System.out.print(membershipNumber);

				return null;
			}
		}
		database.get(candidateNameBird).addMemberNum(membershipNumber);
		database.get(candidateNameBird).setVotes(database.get(candidateNameBird).getVotes() + 1);

		return database.get(candidateNameBird).getCandidate();
	}

	@Override
	// Here the votes for each Candidate name is counted
	public void countVote() {
		int numVote;
		List<Vote> list = new ArrayList<Vote>();
		for (Map.Entry<String, Vote> e : database.entrySet()) {
			list.add(e.getValue());
		}
		for (Vote b : list) {
			numVote = 0;
			for (int i = 0; i < b.ReturnMembershipNum().size(); i++) {
				numVote++;
			}
			b.setVotes(numVote);
			database.replace(b.getCandidate().getCandidateName(), b);
		}
	}

	// Here the vote for the candidate is removed
	public void Remove(String membershipNumber, String candidateNameBird) {

		database.get(candidateNameBird).ReturnMembershipNum().remove(membershipNumber);
		database.get(candidateNameBird).setVotes(database.get(candidateNameBird).getVotes() - 1);

	}

}
