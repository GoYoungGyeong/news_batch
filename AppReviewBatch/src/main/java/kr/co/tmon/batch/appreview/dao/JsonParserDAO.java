package kr.co.tmon.batch.appreview.dao;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author 김종환
 *
 * 지정된 url에서 json object를 가져오는 DAO
 *
 */

@Repository
public class JsonParserDAO {
	public JSONObject getJson(String urlToGetJsonDocument) throws IOException, ParseException {
		URL url = new URL(urlToGetJsonDocument);
		InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream(), "UTF-8");
		JSONObject jsonObject = (JSONObject) JSONValue.parseWithException(inputStreamReader);
		
		return jsonObject;
	}
}
