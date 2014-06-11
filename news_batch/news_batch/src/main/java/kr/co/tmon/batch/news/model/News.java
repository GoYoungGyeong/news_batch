package kr.co.tmon.batch.news.model;

/**
 * @author 고영경
 * 
 */
import java.sql.Date;

public class News {
	private int newsID;
	private String newsSocialCorpCode;
	private String newsTitle;
	private String newsPreview;
	private Date newsDate;
	private String newsImage;
	private String newsLink;
	private String newsProvider;
	private int newsCount;
	private int similarNews;

	public int getNewsID() {
		return newsID;
	}

	public void setNewsID(int newsID) {
		this.newsID = newsID;
	}

	public String getNewsSocialCorpCode() {
		return newsSocialCorpCode;
	}

	public void setNewsSocialCorpCode(String newsSocialCorpCodeList) {
		this.newsSocialCorpCode = newsSocialCorpCodeList;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsPreview() {
		return newsPreview;
	}

	public void setNewsPreview(String newsPreview) {
		this.newsPreview = newsPreview;
	}

	public Date getNewsDate() {
		return newsDate;
	}

	public void setNewsDate(Date newsDate) {
		this.newsDate = newsDate;
	}

	public String getNewsImage() {
		return newsImage;
	}

	public void setNewsImage(String newsImage) {
		this.newsImage = newsImage;
	}

	public String getNewsLink() {
		return newsLink;
	}

	public void setNewsLink(String newsLink) {
		this.newsLink = newsLink;
	}

	public String getNewsProvider() {
		return newsProvider;
	}

	public void setNewsProvider(String newsProvider) {
		this.newsProvider = newsProvider;
	}

	public int getNewsCount() {
		return newsCount;
	}

	public void setNewsCount(int newsCount) {
		this.newsCount = newsCount;
	}

	public int getSimilarNews() {
		return similarNews;
	}

	public void setSimilarNews(int similarNews) {
		this.similarNews = similarNews;
	}

}
