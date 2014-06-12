package kr.co.tmon.batch.appreview.controller;

import java.io.IOException;
import java.text.ParseException;

import kr.co.tmon.batch.appreview.bo.AppReviewBO;
import kr.co.tmon.batch.appreview.bo.MonthlyAppRatingBO;
import kr.co.tmon.batch.appreview.bo.RatingOfAppBO;
import kr.co.tmon.batch.appreview.bo.RatingOfAppVersionBO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 
 * @author 김종환
 * 
 */
@Controller
public class AppReviewDbBatchController {
	@Autowired
	private AppReviewBO appReviewBO;

	@Autowired
	private RatingOfAppVersionBO ratingOfAppVersionBO;

	@Autowired
	private MonthlyAppRatingBO monthlyAppRatingBO;

	@Autowired
	private RatingOfAppBO ratingOfAppBO;
	
	public void runAppReviewDbUpdateBatch() throws IOException, org.json.simple.parser.ParseException, ParseException {
		appReviewBO.insertLastestReview();
		ratingOfAppVersionBO.insertAppRatingData();
		monthlyAppRatingBO.insertCurrentMonthAppRating();
		ratingOfAppBO.updateRatingOfApp();
		
	}

}
