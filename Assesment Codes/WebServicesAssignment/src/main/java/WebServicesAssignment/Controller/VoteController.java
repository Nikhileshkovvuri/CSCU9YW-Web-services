package WebServicesAssignment.Controller;



import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.context.annotation.Bean;
import java.util.List;
import java.util.stream.Collectors;
import java.lang.reflect.Member;
import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.server.ResponseStatusException;
import WebServicesAssignment.Model.*;
import WebServicesAssignment.Services.*;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin
public class VoteController {
	private VoteService ballotServicesO;
	private CandidateService candidateServiesO;

	public VoteController(CandidateService candidateServiesO, VoteService ballotServicesO) {
		this.candidateServiesO = candidateServiesO;
		this.ballotServicesO = ballotServicesO;
	}

	@GetMapping("/candidateBN/{candidateNameBird}")
	//Here the program are linking to the Admin html page.
	public Candidate getCandidate(@PathVariable String candidateNameBird) {
		Candidate candidateBird = candidateServiesO.getCandidate(candidateNameBird);
		if (candidateBird == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return candidateBird;
	}

	@GetMapping("/candidateBN")
	//List of candidate is sent for display
	public List<Candidate> getAllCandidates() {

		List<Candidate> list = candidateServiesO.getCandidate();
		return list;
	}

	@GetMapping("/Votes/{candidateNameBird}")
	//here the program is linking to the voter html page.
	public EntityModel<Vote> getVote(@PathVariable String candidateNameBird) {
		Vote ballot = ballotServicesO.getVote(candidateNameBird);
		if (ballot == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return EntityModel.of(ballot, linkTo(methodOn(VoteController.class).getVote(candidateNameBird)).withSelfRel(),
				linkTo(methodOn(VoteController.class).getAllVotes()).withRel("Ballots"));
	}

	@GetMapping("/votes")
	//Here gets the vote information
	public List<Vote> getAllVotes() {

		List<Vote> list = ballotServicesO.getAllVotes();
		return list;
	}

	@GetMapping("/votes/VoteAdd")
	//Vote is added to the database
	public ResponseEntity<List> countVote() {
		ballotServicesO.countVote();
		return new ResponseEntity<List>(ballotServicesO.getAllVotes(), HttpStatus.OK);
	}

	@PutMapping("/votes/VotePost/{candidateNameBird}")
	//Vote is checked to be in the database
	public ResponseEntity<Candidate> postVote(@PathVariable String candidateNameBird,
			@RequestBody WebServicesAssignment.Model.Member members) {

		Candidate candidateBird = (ballotServicesO.Post(members.getMembershipNumber(), candidateNameBird));
		if (candidateBird == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Candidate>(candidateBird,null,201);


		}

	@DeleteMapping("/votes/VoteRemove/{candidateNameBird}")
	//Vote is deleted from the database
	public ResponseEntity<String> removeVote(@PathVariable String candidateNameBird,
			@RequestBody WebServicesAssignment.Model.Member members) {
		ballotServicesO.Remove(members.getMembershipNumber(), candidateNameBird);
		return new ResponseEntity<String>(null, null, 201);
	}
}
