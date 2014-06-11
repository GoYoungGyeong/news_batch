package kr.co.tmon.socialnews.dao;
/**
 * @author koyk091302
 */
import kr.co.tmon.batch.news.dao.RecordTodayNewsDAO;
import kr.co.tmon.batch.news.model.CountSocialNews;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext*.xml"})
public class RecordTodayNewsDAOTest {
	@Autowired
	private RecordTodayNewsDAO recordTodayNewsDAO;
	
	//@Autowired
	//private CountSocialNewsDAO countSocialNewsDAO;
	private CountSocialNews countSocialNews = new CountSocialNews();
	@Before
	public void setTest() {
		countSocialNews = new CountSocialNews();
		countSocialNews.setDate("2014-05-26");
		countSocialNews.setNewsCount(41);
		countSocialNews.setSocialCorpCode("cp");
	}

	@Test
	public void selectTodayNewsCountForInsert_특정날짜의_뉴스갯수() {
		System.out.println(recordTodayNewsDAO.selectTodayNewsCountForInsert("cp", "2014-05-26"));
	}
//	@Transactional
//	@Test
//	public void insertNews_들어갔는지확인() { 
//		System.out.println("before insert : "+ countSocialNewsDAO.selectNewsCount("2014-05-26").size());
//		recordTodayNewsDAO.insertNews(countSocialNews);
//		System.out.println("after insert : "+ countSocialNewsDAO.selectNewsCount("2014-05-26").size());
//	}
}
