package kr.co.tmon.batch.appreview.bo;

import java.sql.Date;
import java.text.ParseException;

import kr.co.tmon.batch.appreview.dao.AppReviewDAO;
import kr.co.tmon.batch.appreview.dao.MonthlyAppRatingDAO;
import kr.co.tmon.batch.appreview.model.MonthlyAppRatingModel;
import kr.co.tmon.batch.appreview.util.MonthStringToSpecificDate;
import kr.co.tmon.batch.appreview.util.SubDecimal;
import kr.co.tmon.batch.appreview.util.SubstringForYearPlusMonth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 김종환
 * 
 */

@Service
public class MonthlyAppRatingBO {
	@Autowired
	private MonthlyAppRatingDAO monthlyAppRatingDAO;

	@Autowired
	private AppReviewDAO appReviewDAO;
	
	@Scheduled(fixedDelay = 86400000)
	public void insertCurrentMonthAppRating() throws ParseException {
		SubstringForYearPlusMonth substringForYearPlusMonth = new SubstringForYearPlusMonth();
		String monthString = substringForYearPlusMonth.getCurrentMonthString();
		MonthStringToSpecificDate monthStringToSpecificDate = new MonthStringToSpecificDate();
		Date startDate = monthStringToSpecificDate.getFirstDayOfMonthForDateType(monthString);
		Date endDate = monthStringToSpecificDate.getLastDayOfMonthForDateType(monthString);

		MonthlyAppRatingModel monthlyAppRating = appReviewDAO.selectMonthlyAppRating(monthString, startDate, endDate);
		monthlyAppRating = subDemicalOfRating(monthlyAppRating);
		monthlyAppRatingDAO.insertMonthlyAppRating(monthlyAppRating);
	}
	
	private MonthlyAppRatingModel subDemicalOfRating(MonthlyAppRatingModel monthlyAppRating) {
		SubDecimal subDecimal = new SubDecimal();

		monthlyAppRating.setCoupangRating(subDecimal.subDecimalFromOriginalFloat(monthlyAppRating.getCoupangRating()));
		monthlyAppRating.setTmonRating(subDecimal.subDecimalFromOriginalFloat(monthlyAppRating.getTmonRating()));
		monthlyAppRating.setWemapRating(subDecimal.subDecimalFromOriginalFloat(monthlyAppRating.getWemapRating()));

		return monthlyAppRating;
	}
}
