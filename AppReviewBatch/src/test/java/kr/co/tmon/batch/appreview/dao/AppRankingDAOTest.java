package kr.co.tmon.batch.appreview.dao;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import kr.co.tmon.batch.appreview.model.AppRankingModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext*.xml" })
public class AppRankingDAOTest {
	@Autowired
	private AppRankingDAO appRankingDAO;

	@Transactional
	@Test
	public void 정상적으로_DB에_데이터가_삽입되는지_테스트() {
		appRankingDAO.insertAppRanking(generateSampleModel());
	}

	private AppRankingModel generateSampleModel() {
		AppRankingModel appRanking = new AppRankingModel();
		appRanking.setCoupangRank(5);
		appRanking.setTmonRank(7);
		appRanking.setWemapRank(43);
		appRanking.setDateString("2014-06-20 03시");

		return appRanking;
	}
}
