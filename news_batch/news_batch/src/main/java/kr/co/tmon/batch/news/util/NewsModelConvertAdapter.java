package kr.co.tmon.batch.news.util;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import kr.co.tmon.batch.news.model.News;
import kr.co.tmon.batch.news.model.ParsedNews;

/**
 * 
 * @author 김종환
 * 
 * xml로 넘어온 데이터를 news Model에 맞게끔 전환시켜주는 util클래스
 * 
 */

public class NewsModelConvertAdapter {
	public List<News> convertToNewsListForDB(List<ParsedNews> xmlParsedNewsList) throws ParseException {
		ArrayList<News> newsList = new ArrayList<>();

		for (int indexOfNewsList = xmlParsedNewsList.size() - 1; indexOfNewsList >= 0; indexOfNewsList--)
			newsList.add(convertParsedNews(xmlParsedNewsList.get(indexOfNewsList), xmlParsedNewsList.size() - (1 + indexOfNewsList)));

		return newsList;
	}

	private News convertParsedNews(ParsedNews parsedNews, int indexOfList) throws ParseException {
		TypeChangeBetweenDateAndString typeChangeBetweenDateAndString = new TypeChangeBetweenDateAndString();

		News news = new News();
		news.setNewsCount(0);
		news.setNewsTitle(parsedNews.getTitle());
		news.setNewsSocialCorpCode(parsedNews.getSocialName());
		news.setNewsProvider(parsedNews.getProvider());
		news.setNewsPreview(parsedNews.getPreview());
		news.setNewsLink(parsedNews.getLink());
		news.setNewsImage(parsedNews.getImage());
		news.setNewsDate(typeChangeBetweenDateAndString.exchangeToDateType(parsedNews.getDate()));
		news.setNewsID(setNewsId(news.getNewsDate(), indexOfList));
		news.setSimilarNews(Integer.valueOf(parsedNews.getSimilarNews()));
		return news;
	}

	int setNewsId(Date newsDate, int newsIndex) {
		StringBuilder stringBuilder = dateToString(newsDate);

		String newsIndexToString = String.format("%03d", newsIndex);
		stringBuilder.append(newsIndexToString);

		return Integer.valueOf(stringBuilder.toString());
	}

	private StringBuilder dateToString(Date newsDate) {
		StringBuilder stringBuilder = new StringBuilder();
		String[] splitedDateString = newsDate.toString().split("-");
		splitedDateString[0] = splitedDateString[0].substring(2);

		for (String string : splitedDateString)
			stringBuilder.append(string);
		
		return stringBuilder;
	}
}
