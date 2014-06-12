package kr.co.tmon.batch.appreview.util;

import kr.co.tmon.batch.appreview.model.AppReviewModel;

import org.json.simple.JSONObject;

/**
 * 
 * @author 김종환
 * 
 */

public class JsonParsedObjectToAppReview {
	public AppReviewModel bindIteratorToModel(JSONObject parsedObject) throws java.text.ParseException {
		AppReviewModel appReview = new AppReviewModel();

		appReview.setAppVersion((String) parsedObject.get("androidAppVersion"));
		appReview.setReviewContext((String) parsedObject.get("reviewContent"));
		appReview.setReviewerID((String) parsedObject.get("userName"));
		appReview.setReviewerLink((String) parsedObject.get("userLink"));
		appReview.setReviewLink((String) parsedObject.get("reviewLink"));
		appReview.setReviewTitle((String) parsedObject.get("reviewTitle"));
		appReview.setAppName((String) parsedObject.get("androidAppName"));

		TypeChangeBetweenDateAndString typeChangeBetweenDateAndString = new TypeChangeBetweenDateAndString();
		String dateString = (String) parsedObject.get("reviewDate");
		appReview.setWrittenDate(typeChangeBetweenDateAndString.exchangeToDateType(dateString));

		String ratingString = (String) parsedObject.get("starScore");
		appReview.setRating(Integer.parseInt(ratingString));

		ConvertCorpNameToCode convertCorpNameToCode = new ConvertCorpNameToCode();
		appReview.setCorpCode(convertCorpNameToCode.corpNameToCode((String) parsedObject.get("companyName")));

		return appReview;
	}
}
