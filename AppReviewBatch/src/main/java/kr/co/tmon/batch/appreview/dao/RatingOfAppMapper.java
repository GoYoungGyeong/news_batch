package kr.co.tmon.batch.appreview.dao;

import kr.co.tmon.batch.appreview.model.RatingOfAppModel;

/**
 * 
 * @author 김종환
 *
 */

public interface RatingOfAppMapper {
	void insertRatingOfApp(RatingOfAppModel ratingOfApp);
	void updateRatingOfApp(RatingOfAppModel ratingOfAppModel);
	RatingOfAppModel selectRatingOfApp();
}
