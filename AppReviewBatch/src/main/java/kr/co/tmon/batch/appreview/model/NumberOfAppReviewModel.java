package kr.co.tmon.batch.appreview.model;

/**
 * 
 * @author 김종환
 * 
 */

public class NumberOfAppReviewModel {
	private int numberOfCoupangAppReview;
	private int numberOfTmonAppReview;
	private int numberOfWemapAppReview;
	private int numberOfTmonplusAppReview;
	private String monthString;

	public String getMonthString() {
		return monthString;
	}

	public void setMonthString(String monthString) {
		this.monthString = monthString;
	}

	public int getNumberOfTmonplusAppReview() {
		return numberOfTmonplusAppReview;
	}

	public void setNumberOfTmonplusAppReview(int numberOfTmonplusAppReview) {
		this.numberOfTmonplusAppReview = numberOfTmonplusAppReview;
	}

	public int getNumberOfCoupangAppReview() {
		return numberOfCoupangAppReview;
	}

	public void setNumberOfCoupangAppReview(int numberOfCoupangAppReview) {
		this.numberOfCoupangAppReview = numberOfCoupangAppReview;
	}

	public int getNumberOfTmonAppReview() {
		return numberOfTmonAppReview;
	}

	public void setNumberOfTmonAppReview(int numberOfTmonAppReview) {
		this.numberOfTmonAppReview = numberOfTmonAppReview;
	}

	public int getNumberOfWemapAppReview() {
		return numberOfWemapAppReview;
	}

	public void setNumberOfWemapAppReview(int numberOfWemapAppReview) {
		this.numberOfWemapAppReview = numberOfWemapAppReview;
	}

}
