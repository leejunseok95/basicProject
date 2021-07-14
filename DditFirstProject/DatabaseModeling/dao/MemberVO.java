package dao;

public class MemberVO {
	private String memberId;
	private String memberLoginId;
	private String memberPass;
	private String memberName;
	private String memberAge;
	private String memberTelNum;
	private String memberAuthority;
	private String memberMileage;

	public MemberVO() {
	}

	public MemberVO(String memberId, String memberLoginId, String memberPass, String memberName, String memberAge,
			String memberTelNum, String memberAuthority, String memberMileage) {
		super();
		this.memberId = memberId;
		this.memberLoginId = memberLoginId;
		this.memberPass = memberPass;
		this.memberName = memberName;
		this.memberAge = memberAge;
		this.memberTelNum = memberTelNum;
		this.memberAuthority = memberAuthority;
		this.memberMileage = memberMileage;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberLoginId() {
		return memberLoginId;
	}

	public void setMemberLoginId(String memberLoginId) {
		this.memberLoginId = memberLoginId;
	}

	public String getMemberPass() {
		return memberPass;
	}

	public void setMemberPass(String memberPass) {
		this.memberPass = memberPass;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(String memberAge) {
		this.memberAge = memberAge;
	}

	public String getMemberTelNum() {
		return memberTelNum;
	}

	public void setMemberTelNum(String memberTelNum) {
		this.memberTelNum = memberTelNum;
	}

	public String getMemberAuthority() {
		return memberAuthority;
	}

	public void setMemberAuthority(String memberAuthority) {
		this.memberAuthority = memberAuthority;
	}

	public String getMemberMileage() {
		return memberMileage;
	}

	public void setMemberMileage(String memberMileage) {
		this.memberMileage = memberMileage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberVO [memberId=");
		builder.append(memberId);
		builder.append(", memberLoginId=");
		builder.append(memberLoginId);
		builder.append(", memberPass=");
		builder.append(memberPass);
		builder.append(", memberName=");
		builder.append(memberName);
		builder.append(", memberAge=");
		builder.append(memberAge);
		builder.append(", memberTelNum=");
		builder.append(memberTelNum);
		builder.append(", memberAuthority=");
		builder.append(memberAuthority);
		builder.append(", memberMileage=");
		builder.append(memberMileage);
		builder.append("]");
		return builder.toString();
	}

}
