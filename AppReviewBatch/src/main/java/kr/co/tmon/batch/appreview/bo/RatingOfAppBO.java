package kr.co.tmon.batch.appreview.bo;

import java.io.IOException;

import kr.co.tmon.batch.appreview.dao.RatingOfAppDAO;
import kr.co.tmon.batch.appreview.model.RatingOfAppModel;
import kr.co.tmon.batch.appreview.util.ExtractFromJson;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class RatingOfAppBO {
	@Autowired
	private RatingOfAppDAO ratingOfAppDAO;

	@Scheduled(fixedDelay = 86400000)
	public void updateRatingOfApp() throws IOException, ParseException {
		ExtractFromJson extractFromJson = new ExtractFromJson();
		RatingOfAppModel ratingOfApp = extractFromJson.getRatingOfApp();

		ratingOfAppDAO.updateRatingOfApp(ratingOfApp);
	}
}
