package kr.co.tmon.batch.appreview.dao;

import kr.co.tmon.batch.appreview.model.RatingOfAppModel;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RatingOfAppDAO {
	@Autowired
	private SqlSession sqlSession;

	public void updateRatingOfApp(RatingOfAppModel ratingOfAppModel) {
		RatingOfAppMapper ratingOfAppMapper = sqlSession.getMapper(RatingOfAppMapper.class);
		ratingOfAppMapper.updateRatingOfApp(ratingOfAppModel);
	}

}
