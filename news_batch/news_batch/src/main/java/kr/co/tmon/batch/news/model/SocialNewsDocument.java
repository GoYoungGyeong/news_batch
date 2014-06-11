package kr.co.tmon.batch.news.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author yeseul23
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "news")
public class SocialNewsDocument {
	@XmlElement(name = "item")
	private List<ParsedNews> parsedNewsList;

	public SocialNewsDocument() {
		parsedNewsList = new ArrayList<ParsedNews>();
	}

	public List<ParsedNews> getParsedNewsList() {
		return parsedNewsList;
	}

	public void setParsedNewsList(List<ParsedNews> parsedNewsList) {
		this.parsedNewsList = parsedNewsList;
	}

}
