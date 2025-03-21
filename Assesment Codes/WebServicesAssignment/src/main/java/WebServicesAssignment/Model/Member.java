package WebServicesAssignment.Model;

public class Member {
	private String memberName;
	private String membershipNumber;
	private int memberAge;
	private String regionOfScot;

	public Member() {
		memberName = "_";
		membershipNumber = "-";
		memberAge = 0;
		regionOfScot = "_";
	}

	/**
	 * This constructor is being used to create a member and all the necessary
	 * attributes.
	 * 
	 * @param membershipNumber The membership identification number of the member is
	 *                         given here.
	 * @param memberName       The name of the member is given here.
	 * @param memberAge        The age of the member is given here.
	 * @param regionOfScot     In which region of the Scotland does the member live.
	 */
	public Member(String memberName, String membershipNumber, int memberAge, String regionOfScot) {
		this.memberName = memberName;
		this.membershipNumber = membershipNumber;
		this.memberAge = memberAge;
		this.regionOfScot = regionOfScot;
	}

	/**
	 * This constructor is being used to create a member and all the necessary
	 * attributes.
	 * 
	 * @param memberName The name of the member is given here.
	 */
	public Member(Member members) {
		this.memberName = members.memberName;
		this.membershipNumber = members.membershipNumber;
		this.memberAge = members.memberAge;
		this.regionOfScot = members.regionOfScot;
	}

	// Gets the member's membershipNumber
	public String getMembershipNumber() {
		return membershipNumber;
	}

	// Sets the member's membershipNumber
	public void setMembershipNumber(String membershipNumber) {
		this.membershipNumber = membershipNumber;
	}

	// Gets the member name
	public String getMembername() {
		return memberName;
	}

	// Sets the member name
	public void setMembername(String memberName) {
		this.memberName = memberName;
	}

	// Gets the age of member
	public int getAge() {
		return memberAge;
	}

	// Sets the age of member
	public void setAge(int age) {
		this.memberAge = age;
	}

	// Gets the region of Scotland the member lives in.
	public String getRegion() {
		return regionOfScot;
	}

	// Sets the region of Scotland the member lives in.
	public void setRegion(String region) {
		this.regionOfScot = region;
	}

	@Override

	public String toString() {
		return "Participating Members{" + "Member ID='" + membershipNumber + '\'' + ",Person name='" + memberName + '\''
				+ ", Person age=" + memberAge + ", Scotland Regeion='" + regionOfScot + '\'' + '}';
	}

}
