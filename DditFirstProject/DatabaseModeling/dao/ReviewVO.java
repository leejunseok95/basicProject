package dao;

public class ReviewVO {
	private String ReviewId;
	private String ReviewContents;
	private int ReviewStar;
	OrderVO orderId;
	
	public ReviewVO() {
	}

	public ReviewVO(String reviewId, String reviewContents, int reviewStar, OrderVO orderId) {
		super();
		ReviewId = reviewId;
		ReviewContents = reviewContents;
		ReviewStar = reviewStar;
		this.orderId = orderId;
	}

	public String getReviewId() {
		return ReviewId;
	}

	public void setReviewId(String reviewId) {
		ReviewId = reviewId;
	}

	public String getReviewContents() {
		return ReviewContents;
	}

	public void setReviewContents(String reviewContents) {
		ReviewContents = reviewContents;
	}

	public int getReviewStar() {
		return ReviewStar;
	}

	public void setReviewStar(int reviewStar) {
		ReviewStar = reviewStar;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReviewVO [ReviewId=");
		builder.append(ReviewId);
		builder.append(", ReviewContents=");
		builder.append(ReviewContents);
		builder.append(", ReviewStar=");
		builder.append(ReviewStar);
		builder.append(", orderId=");
		builder.append(orderId);
		builder.append("]");
		return builder.toString();
	}
	
	
}
