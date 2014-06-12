package kr.co.tmon.batch.appreview.model;


/**
 * 
 * @author 김종환
 *
 */

public class MonthlyAppRatingModel {
	private String reviewedMonth;
	private float coupangRating;
	private float wemapRating;
	private float tmonRating;

	public String getReviewedMonth() {
		return reviewedMonth;
	}

	public void setReviewedMonth(String reviewedMonth) {
		this.reviewedMonth = reviewedMonth;
	}

	public float getCoupangRating() {
		return coupangRating;
	}

	public void setCoupangRating(float coupangRating) {
		this.coupangRating = coupangRating;
	}

	public float getWemapRating() {
		return wemapRating;
	}

	public void setWemapRating(float wemapRating) {
		this.wemapRating = wemapRating;
	}

	public float getTmonRating() {
		return tmonRating;
	}

	public void setTmonRating(float tmonRating) {
		this.tmonRating = tmonRating;
	}
}