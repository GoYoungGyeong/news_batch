package kr.co.tmon.batch.appreview.util;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import kr.co.tmon.batch.appreview.model.AppRankingModel;
import kr.co.tmon.batch.appreview.model.RatingOfAppModel;

import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

public class ExtractFromJsonTest {
	private ExtractFromJson extractAppReviewListFromJson;

	@Before
	public void setup() {
		extractAppReviewListFromJson = new ExtractFromJson();
	}

	@Test
	public void 최신_일주일_데이터를_받아오는지_확인하는_테스트() throws IOException, ParseException, java.text.ParseException {
		assertNotNull(extractAppReviewListFromJson.getAppReviewListAmongLastestWeek());
	}

	@Test
	public void 특정_날짜를_지정했을때_데이터를_받아오는지_확인하는_테스트() throws IOException, ParseException, java.text.ParseException {
		assertNotNull(extractAppReviewListFromJson.getAppReviewListSpecificDate("2013-03-01", "2013-03-01"));
	}

	@Test
	public void rating모델을_정상적으로_받아오는지_테스트() throws IOException, ParseException {
		RatingOfAppModel result = extractAppReviewListFromJson.getRatingOfApp();
		assertNotNull(result);
	}

	@Test
	public void 앱_순위를_정상적으로_받아오는지_테스트() throws IOException, ParseException {
		AppRankingModel result = extractAppReviewListFromJson.getAppRanking();
		assertNotNull(result);
	}
}
