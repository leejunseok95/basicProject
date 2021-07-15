package vo;

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberAge == null) ? 0 : memberAge.hashCode());
		result = prime * result + ((memberAuthority == null) ? 0 : memberAuthority.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((memberLoginId == null) ? 0 : memberLoginId.hashCode());
		result = prime * result + ((memberMileage == null) ? 0 : memberMileage.hashCode());
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result + ((memberPass == null) ? 0 : memberPass.hashCode());
		result = prime * result + ((memberTelNum == null) ? 0 : memberTelNum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberVO other = (MemberVO) obj;
		if (memberAge == null) {
			if (other.memberAge != null)
				return false;
		} else if (!memberAge.equals(other.memberAge))
			return false;
		if (memberAuthority == null) {
			if (other.memberAuthority != null)
				return false;
		} else if (!memberAuthority.equals(other.memberAuthority))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (memberLoginId == null) {
			if (other.memberLoginId != null)
				return false;
		} else if (!memberLoginId.equals(other.memberLoginId))
			return false;
		if (memberMileage == null) {
			if (other.memberMileage != null)
				return false;
		} else if (!memberMileage.equals(other.memberMileage))
			return false;
		if (memberName == null) {
			if (other.memberName != null)
				return false;
		} else if (!memberName.equals(other.memberName))
			return false;
		if (memberPass == null) {
			if (other.memberPass != null)
				return false;
		} else if (!memberPass.equals(other.memberPass))
			return false;
		if (memberTelNum == null) {
			if (other.memberTelNum != null)
				return false;
		} else if (!memberTelNum.equals(other.memberTelNum))
			return false;
		return true;
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
