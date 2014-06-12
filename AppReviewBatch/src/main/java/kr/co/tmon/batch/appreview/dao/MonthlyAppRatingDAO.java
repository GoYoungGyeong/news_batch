package kr.co.tmon.batch.appreview.dao;

import kr.co.tmon.batch.appreview.model.MonthlyAppRatingModel;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author 김종환
 *
 */

@Repository
public class MonthlyAppRatingDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public void insertMonthlyAppRating(MonthlyAppRatingModel monthlyAppRating) {
		MonthlyAppRatingMapper monthlyAppRatingMapper = sqlSession.getMapper(MonthlyAppRatingMapper.class);
		monthlyAppRatingMapper.insertMonthlyAppRating(monthlyAppRating);
	}
}
