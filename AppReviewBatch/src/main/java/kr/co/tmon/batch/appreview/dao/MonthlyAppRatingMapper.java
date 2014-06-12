package kr.co.tmon.batch.appreview.dao;

import java.util.List;

import kr.co.tmon.batch.appreview.model.MonthlyAppRatingModel;

/**
 * 
 * @author 김종환
 *
 */

public interface MonthlyAppRatingMapper {
	void insertMonthlyAppRating(MonthlyAppRatingModel monthlyAppRatingModel);

	List<MonthlyAppRatingModel> selectMonthlyAppRating();

}
