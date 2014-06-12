package kr.co.tmon.batch.appreview.dao;

import kr.co.tmon.batch.appreview.model.MonthlyAppRatingModel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext*.xml" })
public class MonthlyAppRatingDAOTest {
	@Autowired
	private MonthlyAppRatingDAO monthlyAppRatingDAO;

	@Transactional
	@Test
	public void 데이터_insert가_되는지_확인하는_테스트() {
		MonthlyAppRatingModel monthlyAppRatingModel = new MonthlyAppRatingModel();

		monthlyAppRatingModel.setReviewedMonth("2014-05");
		monthlyAppRatingModel.setCoupangRating((float) 3.1);
		monthlyAppRatingModel.setTmonRating((float) 2.7);
		monthlyAppRatingModel.setWemapRating((float) 2.8);

		monthlyAppRatingDAO.insertMonthlyAppRating(monthlyAppRatingModel);
	}
}
