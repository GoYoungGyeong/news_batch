package kr.co.tmon.batch.appreview.bo;

import java.io.IOException;
import java.util.List;

import kr.co.tmon.batch.appreview.dao.AppReviewDAO;
import kr.co.tmon.batch.appreview.model.AppReviewModel;
import kr.co.tmon.batch.appreview.util.ExtractFromJson;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 김종환
 * 
 */

@Service
public class AppReviewBO {
	@Autowired
	private AppReviewDAO appReviewDAO;
	
	@Scheduled(fixedDelay = 86400000)
	public void insertLastestReview() throws IOException, ParseException, java.text.ParseException {
		ExtractFromJson extractFromJson = new ExtractFromJson();
		List<AppReviewModel> lastestReviewData = extractFromJson.getAppReviewListAmongLastestWeek();
		for (AppReviewModel review : lastestReviewData)
			appReviewDAO.insertAppReview(review);
	}
}
