package kr.co.tmon.batch.appreview.dao;

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
public class RatingOfAppByVersionDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public void insertRatingOfAppByVersion(RatingOfAppByVersionModel ratingOfAppByVersion) {
		RatingOfAppByVersionMapper ratingOfAppByVersionMapper = sqlSession.getMapper(RatingOfAppByVersionMapper.class);
		ratingOfAppByVersionMapper.insertRatingOfAppByVersion(ratingOfAppByVersion);
	}
}
