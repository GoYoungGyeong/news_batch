package kr.co.tmon.batch.appreview.model;

/**
 * 
 * @author 김종환
 *
 */

public class RatingOfAppByVersionModel {
	private int ratingOne;
	private int ratingTwo;
	private int ratingThree;
	private int ratingFour;
	private int ratingFive;
	private String appName;
	private String appVersion;
	private float averageRating;

	public int getRatingOne() {
		return ratingOne;
	}

	public void setRatingOne(int ratingOne) {
		this.ratingOne = ratingOne;
	}

	public int getRatingTwo() {
		return ratingTwo;
	}

	public void setRatingTwo(int ratingTwo) {
		this.ratingTwo = ratingTwo;
	}

	public int getRatingThree() {
		return ratingThree;
	}

	public void setRatingThree(int ratingThree) {
		this.ratingThree = ratingThree;
	}

	public int getRatingFour() {
		return ratingFour;
	}

	public void setRatingFour(int ratingFour) {
		this.ratingFour = ratingFour;
	}

	public int getRatingFive() {
		return ratingFive;
	}

	public void setRatingFive(int ratingFive) {
		this.ratingFive = ratingFive;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public float getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(float averageRating) {
		this.averageRating = averageRating;
	}
}
