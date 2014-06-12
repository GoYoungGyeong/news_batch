package kr.co.tmon.batch.appreview.dao;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import kr.co.tmon.batch.appreview.model.AppReviewModel;
import kr.co.tmon.batch.appreview.model.MonthlyAppRatingModel;
import kr.co.tmon.batch.appreview.model.RatingOfAppByVersionModel;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author 김종환
 * 
 */

@Repository
public class AppReviewDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public void insertAppReview(AppReviewModel appReview) {
		AppReviewMapper appReviewMapper = sqlSession.getMapper(AppReviewMapper.class);
		appReviewMapper.insertAppReviewToUserTable(appReview);
		appReviewMapper.insertAppReviewToReviewTable(appReview);
	}
	
	public List<RatingOfAppByVersionModel> selectAppRatingByVersion(String appName) {
		AppReviewMapper appReviewMapper = sqlSession.getMapper(AppReviewMapper.class);

		return appReviewMapper.selectReviewForRatingByVersion(appName);
	}
	
	public MonthlyAppRatingModel selectMonthlyAppRating(String monthString, Date startDate, Date endDate) throws ParseException {
		AppReviewMapper appReviewMapper = sqlSession.getMapper(AppReviewMapper.class);

		MonthlyAppRatingModel monthlyAppRating = appReviewMapper.selectMonthlyAppRating(startDate, endDate);
		monthlyAppRating.setReviewedMonth(monthString);

		return monthlyAppRating;
	}
}
