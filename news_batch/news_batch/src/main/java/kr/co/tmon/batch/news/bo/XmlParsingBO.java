package kr.co.tmon.batch.news.bo;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.List;

import javax.xml.bind.JAXBException;

import kr.co.tmon.batch.news.dao.LocalInsertNewsDAO;
import kr.co.tmon.batch.news.dao.RemoteGetNewsDAO;
import kr.co.tmon.batch.news.model.News;
import kr.co.tmon.batch.news.model.ParsedNews;
import kr.co.tmon.batch.news.util.NewsModelConvertAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 
 * @author yeseul23
 * 
 */
@Service
public class XmlParsingBO {
	@Autowired
	private LocalInsertNewsDAO localInsertNewsDAO;
	@Autowired
	private RemoteGetNewsDAO remoteGetNewsDAO;
	
	@Scheduled(fixedDelay = 10800000)
	public void insertParsingNewsData() throws ParseException, MalformedURLException, JAXBException {
		NewsModelConvertAdapter newsModelConvertAdapter = new NewsModelConvertAdapter();
		List<ParsedNews> parsedNewsList = remoteGetNewsDAO.getSocialNewsDocument().getParsedNewsList();
		List<News> newsList = newsModelConvertAdapter.convertToNewsListForDB(parsedNewsList);
		if(newsList.size() > 0)
			localInsertNewsDAO.insertNews(newsList);
	}
}