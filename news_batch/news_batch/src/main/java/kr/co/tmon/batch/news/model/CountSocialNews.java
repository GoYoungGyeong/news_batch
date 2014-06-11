package kr.co.tmon.batch.news.model;

/**
 * 
 * @author 고영경
 *
 */
public class CountSocialNews {
	private String date;
	private String socialCorpCode;
	private int newsCount;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSocialCorpCode() {
		return socialCorpCode;
	}
	public void setSocialCorpCode(String socialCorpCode) {
		this.socialCorpCode = socialCorpCode;
	}
	public int getNewsCount() {
		return newsCount;
	}

	public void setNewsCount(int newsCount) {
		this.newsCount = newsCount;
	}

	
}