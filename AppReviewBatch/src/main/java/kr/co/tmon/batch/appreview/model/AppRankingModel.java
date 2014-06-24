package kr.co.tmon.batch.appreview.model;

/**
 * 
 * @author 김종환
 *
 */

public class AppRankingModel {
	private String dateString;
	private int tmonRank;
	private int coupangRank;
	private int wemapRank;

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	public int getTmonRank() {
		return tmonRank;
	}

	public void setTmonRank(int tmonRank) {
		this.tmonRank = tmonRank;
	}

	public int getCoupangRank() {
		return coupangRank;
	}

	public void setCoupangRank(int coupangRank) {
		this.coupangRank = coupangRank;
	}

	public int getWemapRank() {
		return wemapRank;
	}

	public void setWemapRank(int wemapRank) {
		this.wemapRank = wemapRank;
	}

}
