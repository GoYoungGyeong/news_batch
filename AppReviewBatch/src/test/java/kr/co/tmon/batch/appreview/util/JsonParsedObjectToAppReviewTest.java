package kr.co.tmon.batch.appreview.util;

import static org.junit.Assert.assertNotNull;

import java.text.ParseException;

import kr.co.tmon.batch.appreview.model.AppReviewModel;

import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;

public class JsonParsedObjectToAppReviewTest {
	private JsonParsedObjectToAppReview jsonParsedObjectToAppReview;

	@Before
	public void setup() {
		jsonParsedObjectToAppReview = new JsonParsedObjectToAppReview();
	}

	@Test
	public void 올바르게_제이슨_파싱한_오브젝트를_앱리뷰_모델로_반환하는지_확인하는_테스트() throws ParseException {
		JSONObject jsonObject = generateSampleObject();
		AppReviewModel sampleForAppReview = jsonParsedObjectToAppReview.bindIteratorToModel(jsonObject);

		assertNotNull(sampleForAppReview);
		System.out.println(sampleForAppReview.getWrittenDate());
	}

	private JSONObject generateSampleObject() {
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("androidAppVersion", "3.1.4");
		jsonObject.put("reviewContent", "blah");
		jsonObject.put("userName", "가가");
		jsonObject.put("userLink", "나나");
		jsonObject.put("reviewLink", "올레");
		jsonObject.put("reviewTitle", "제목");
		jsonObject.put("androidAppName", "티몬");
		jsonObject.put("reviewDate", "2014-05-05");
		jsonObject.put("companyName", "티켓몬스터");
		jsonObject.put("starScore", "5");

		return jsonObject;
	}
}
