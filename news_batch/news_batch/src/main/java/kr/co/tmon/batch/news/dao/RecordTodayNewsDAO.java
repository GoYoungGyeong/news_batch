package kr.co.tmon.batch.news.dao;
/**
 * 
 * @author 고영경
 * 
 */
import kr.co.tmon.batch.news.model.CountSocialNews;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RecordTodayNewsDAO {
	@Autowired
	private SqlSession sqlSession;

	public void insertNews(CountSocialNews countSocialNews) {
		NewsMapper newsMapper = sqlSession.getMapper(NewsMapper.class);

		newsMapper.insertNewsCount(countSocialNews);
	}

	public int selectTodayNewsCountForInsert(String social_corpCode, String today) {
		NewsMapper newsMapper = sqlSession.getMapper(NewsMapper.class);

		return newsMapper.selectTodayNewsCountForInsert(social_corpCode, today);
	}
}
