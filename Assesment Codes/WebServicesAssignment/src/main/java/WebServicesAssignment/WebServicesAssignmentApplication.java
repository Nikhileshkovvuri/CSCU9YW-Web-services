package WebServicesAssignment;


import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import WebServicesAssignment.Model.*;
import WebServicesAssignment.Services.*;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class WebServicesAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServicesAssignmentApplication.class, args);
	}
	@Bean
	public CommandLineRunner initDB(CandidateService candidateServiesO, VoteService ballotServicesO)
	{
		return (args) -> {
			// Name and details of candidate birds are given here
			candidateServiesO.addCandidate(new Candidate("Snowy Owl", "Bubo scandiacus","white, artic birds, very rare in Scotland"));
			candidateServiesO.addCandidate(new Candidate("Common Raven", "Corvus corax","Black, social bird, Often viewed as bad omen"));
			candidateServiesO.addCandidate(new Candidate("Golden Eagle", "Aquila chrysaetos","Large bird of prey, Majestic."));
            for (int i=0; i<candidateServiesO.getCandidate().size(); i++) {
            	ballotServicesO.addVote(new Vote(candidateServiesO.getCandidate().get(i)));
		}
		};
		
	
	}
	}
		
		
		
		
	
