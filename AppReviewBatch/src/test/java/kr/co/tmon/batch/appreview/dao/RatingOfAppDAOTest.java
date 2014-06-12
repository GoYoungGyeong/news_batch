package kr.co.tmon.batch.appreview.dao;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import kr.co.tmon.batch.appreview.model.RatingOfAppModel;

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
public class RatingOfAppDAOTest {
	@Autowired
	private RatingOfAppDAO ratingOfAppDAO;

	@Transactional
	@Test
	public void insert테스트() {
		ratingOfAppDAO.updateRatingOfApp(generateSampleData());
	}

	private RatingOfAppModel generateSampleData() {
		RatingOfAppModel ratingOfApp = new RatingOfAppModel();

		ratingOfApp.setCoupangRating(0);
		ratingOfApp.setWemapRating((float) 2.1);
		ratingOfApp.setTmonplusRating((float) 3.2);
		ratingOfApp.setTmonRating((float) 5);

		return ratingOfApp;
	}
}
