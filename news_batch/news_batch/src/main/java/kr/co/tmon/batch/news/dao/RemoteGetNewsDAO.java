package kr.co.tmon.batch.news.dao;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import kr.co.tmon.batch.news.model.SocialNewsDocument;
import kr.co.tmon.batch.news.util.TypeChangeBetweenDateAndString;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author yeseul23
 * 
 */
@Repository
public class RemoteGetNewsDAO {
	private static final String BASIC_URL_FOR_GETTING_XML = "http://10.5.208.50:8080/social/news.tmon?date=";
	
	public SocialNewsDocument getSocialNewsDocument() throws MalformedURLException, JAXBException {
		URL url = new URL(generateTodayUrl());
		JAXBContext context = JAXBContext.newInstance(SocialNewsDocument.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		return (SocialNewsDocument) unmarshaller.unmarshal(url);
	}

	private String generateTodayUrl() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(BASIC_URL_FOR_GETTING_XML);
		Date date = new Date(System.currentTimeMillis());
		TypeChangeBetweenDateAndString typeChangeBetweenDateAndString = new TypeChangeBetweenDateAndString();
		stringBuilder.append(typeChangeBetweenDateAndString.exchangeToStringType(date));

		return stringBuilder.toString();
	}
}
