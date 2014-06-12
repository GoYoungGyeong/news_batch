package kr.co.tmon.batch.appreview.dao;

import kr.co.tmon.batch.appreview.model.RatingOfAppByVersionModel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext*.xml" })
public class RatingOfAppByVersionDAOTest {
	@Autowired
	private RatingOfAppByVersionDAO ratingOfAppByVersionDAO;

	@Transactional
	@Test
	public void 정상적으로_insert동작이_발생하는지_테스트() {
		ratingOfAppByVersionDAO.insertRatingOfAppByVersion(generateSampleData());
	}

	private RatingOfAppByVersionModel generateSampleData() {
		RatingOfAppByVersionModel ratingOfAppByVersionModel = new RatingOfAppByVersionModel();

		ratingOfAppByVersionModel.setAppName("blah");
		ratingOfAppByVersionModel.setAppVersion("4.5.4");
		ratingOfAppByVersionModel.setAverageRating((float) 2.49);
		ratingOfAppByVersionModel.setRatingFive(1);
		ratingOfAppByVersionModel.setRatingFour(4);
		ratingOfAppByVersionModel.setRatingOne(4);
		ratingOfAppByVersionModel.setRatingTwo(2);
		ratingOfAppByVersionModel.setRatingThree(4);

		return ratingOfAppByVersionModel;
	}
}
