package vo;

public class AddressVO {
	private String AddressAdd2;
	private String MemberId;
	private String AddressAdd1;
	
	public AddressVO() {
	}

	public AddressVO(String addressAdd2, String memberId, String addressAdd1) {
		super();
		AddressAdd2 = addressAdd2;
		MemberId = memberId;
		AddressAdd1 = addressAdd1;
	}

	public String getAddressAdd2() {
		return AddressAdd2;
	}

	public void setAddressAdd2(String addressAdd2) {
		AddressAdd2 = addressAdd2;
	}

	public String getMemberId() {
		return MemberId;
	}

	public void setMemberId(String memberId) {
		MemberId = memberId;
	}

	public String getAddressAdd1() {
		return AddressAdd1;
	}

	public void setAddressAdd1(String addressAdd1) {
		AddressAdd1 = addressAdd1;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddressVO [AddressAdd2=");
		builder.append(AddressAdd2);
		builder.append(", MemberId=");
		builder.append(MemberId);
		builder.append(", AddressAdd1=");
		builder.append(AddressAdd1);
		builder.append("]");
		return builder.toString();
	}

	
}
