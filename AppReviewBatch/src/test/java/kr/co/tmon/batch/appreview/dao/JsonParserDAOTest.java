package kr.co.tmon.batch.appreview.dao;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

public class JsonParserDAOTest {
	private JsonParserDAO jsonParserDAO;

	@Before
	public void setup() {
		jsonParserDAO = new JsonParserDAO();
	}

	@Test
	public void 정해진_url에서_json_객체를_뽑아내는지_테스트() throws IOException, ParseException {
		JSONObject result = jsonParserDAO.getJson("http://10.5.208.50:8080/social/appReview.tmon");
		assertNotNull(result);
	}

}
