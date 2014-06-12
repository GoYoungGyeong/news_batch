package kr.co.tmon.batch.news.bo;

import kr.co.tmon.batch.news.dao.RecordTodayNewsDAO;
import kr.co.tmon.batch.news.model.CountSocialNews;
import kr.co.tmon.batch.news.util.DateCalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 고영경
 *
 */
@Service
public class RecordTodayNewsBO {
	
	@Autowired
	private RecordTodayNewsDAO recordTodayNewsDAO;
	
	@Scheduled(fixedDelay = 12600000)
	public void recordTodayNewsCount() {
		CountSocialNews countTmonNews = makeCountSocialNews("tm");
		CountSocialNews countCoupangNews = makeCountSocialNews("cp");
		CountSocialNews countWemapNews = makeCountSocialNews("wmp");

		recordTodayNewsDAO.insertNews(countTmonNews);
		recordTodayNewsDAO.insertNews(countCoupangNews);
		recordTodayNewsDAO.insertNews(countWemapNews);
	}
	private CountSocialNews makeCountSocialNews(String socialCorpCode) {
		CountSocialNews countSocialNews = new CountSocialNews();
		DateCalculator dateCalculator = new DateCalculator();
		
		countSocialNews.setDate(dateCalculator.getToday());
		countSocialNews.setNewsCount(recordTodayNewsDAO.selectTodayNewsCountForInsert(socialCorpCode, dateCalculator.getToday()));
		countSocialNews.setSocialCorpCode(socialCorpCode);

		return countSocialNews;
	}
}
