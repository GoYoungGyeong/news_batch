package kr.co.tmon.batch.news.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 
 * @author yeseul23
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ParsedNews {
	private String socialName;
	private String title;
	private String preview;
	private String image;
	private String date;
	private String link;
	private String provider;
	private String similarNews;

	public String getSocialName() {
		return socialName;
	}

	public void setSocialName(String socialName) {
		this.socialName = socialName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getSimilarNews() {
		return similarNews;
	}

	public void setSimilarNews(String similarNews) {
		this.similarNews = similarNews;
	}

}
