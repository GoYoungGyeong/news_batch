package kr.co.tmon.batch.appreview.dao;

import kr.co.tmon.batch.appreview.model.AppRankingModel;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppRankingDAO {
	@Autowired
	private SqlSession sqlSession;

	public void insertAppRanking(AppRankingModel appRanking) {
		AppRankingMapper appRankingMapper = sqlSession.getMapper(AppRankingMapper.class);
		appRankingMapper.insertAppRanking(appRanking);
	}

}
