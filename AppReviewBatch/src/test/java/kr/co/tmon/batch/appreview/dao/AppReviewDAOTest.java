package kr.co.tmon.batch.appreview.dao;

import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.text.ParseException;

import kr.co.tmon.batch.appreview.model.AppReviewModel;
import kr.co.tmon.batch.appreview.util.MonthStringToSpecificDate;
import kr.co.tmon.batch.appreview.util.SubstringForYearPlusMonth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext*.xml" })
public class AppReviewDAOTest {
	@Autowired
	private AppReviewDAO appReviewDAO;

	@Transactional
	@Test
	public void appReview_데이터가_인서트되는지_테스트() {
		AppReviewModel appReviewModel = new AppReviewModel();
		appReviewModel.setAppName("티몬");
		appReviewModel.setAppVersion("2.2.2");
		appReviewModel.setCorpCode("tm");
		appReviewModel.setRating(5);
		appReviewModel.setReviewContext("blah");
		appReviewModel.setReviewerID("tony");
		appReviewModel.setReviewerLink("sdalkghdsagiehefs");
		appReviewModel.setReviewLink("asdufhusdhf");
		appReviewModel.setReviewTitle("auewhf");
		appReviewModel.setUserID(2);
		appReviewModel.setWrittenDate(new Date(System.currentTimeMillis()));

		appReviewDAO.insertAppReview(appReviewModel);
	}

	@Test
	public void 앱_버전정보를_review테이블에서_불러오는지_테스트() {
		assertNotNull(appReviewDAO.selectAppRatingByVersion("티몬"));
	}

	@Test
	public void 월간_리뷰_평점을_정상적으로_반환하느지_테스트() throws ParseException {
		SubstringForYearPlusMonth substringForYearPlusMonth = new SubstringForYearPlusMonth();
		MonthStringToSpecificDate monthStringToSpecificDate = new MonthStringToSpecificDate();
		String monthString = substringForYearPlusMonth.getCurrentMonthString();
		Date startDate = monthStringToSpecificDate.getFirstDayOfMonthForDateType(monthString);
		Date endDate = monthStringToSpecificDate.getLastDayOfMonthForDateType(monthString);
		assertNotNull(appReviewDAO.selectMonthlyAppRating(monthString, startDate, endDate));
	}
}
