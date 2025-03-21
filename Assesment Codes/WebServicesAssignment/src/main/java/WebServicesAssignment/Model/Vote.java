package WebServicesAssignment.Model;

import java.util.ArrayList;


public class Vote {
 
	private ArrayList<String> membershipNumber;
	private int vote;
	private Candidate candidateBird;
	
	
	//Constructor
	public Vote() {
		candidateBird = new Candidate();
		vote = 0;
		membershipNumber = new ArrayList<String>();
	}
	public Vote(Candidate birdCandidate) {
		this.vote= 0;
		this.candidateBird = birdCandidate;
		this.membershipNumber= new ArrayList<String>();
	}
   //copy constructor
	public Vote(Vote memberVote) {
		this.vote = memberVote.vote;
		this.candidateBird= memberVote.candidateBird;
		this.membershipNumber=memberVote.membershipNumber;
		
	}
	//Adds member ID number
	public void addMemberNum(String id)
	{
		this.membershipNumber.add(id);
	}
	//Gets the votes
	public int getVotes() {
		return this.vote;
	}
	//Sets the votes
	public void setVotes(int votes ) {
		this.vote=votes;
	}
	//Gets the Candidate
	public  Candidate getCandidate() {
		return this.candidateBird;
	}
	//Sets the candidate
	public void setCandidate(Candidate birdCandidate) {
		this.candidateBird = birdCandidate;
	}
	//Array returns Member ID Number
	public  ArrayList<String> ReturnMembershipNum() {
		return this.membershipNumber;
	}
	//Sets MembershipId number 
	public void setMembershipID(ArrayList<String> membershipid) {
	this.membershipNumber = membershipid;
	}
	@Override
	public String toString() {
		return  "Candidate{" +
	               "Membership ID=\"" + membershipNumber + "\"," +
	               "Count of vote=\"" + vote + "\"," +
	               "Candidate=\"" + candidateBird + "\"" +
	              "}";
	}
		
	}
