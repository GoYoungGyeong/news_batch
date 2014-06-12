package kr.co.tmon.batch.appreview.dao;

import java.sql.Date;
import java.util.List;

import kr.co.tmon.batch.appreview.model.AppReviewModel;
import kr.co.tmon.batch.appreview.model.MonthlyAppRatingModel;
import kr.co.tmon.batch.appreview.model.NumberOfAppReviewModel;
import kr.co.tmon.batch.appreview.model.RatingOfAppByVersionModel;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author 김종환
 * 
 */

public interface AppReviewMapper {
	List<AppReviewModel> selectAppReview(@Param("appName") String appName, @Param("numberOfLoad") int numberOfLoad);

	void insertAppReviewToUserTable(AppReviewModel appReview);

	void insertAppReviewToReviewTable(AppReviewModel appReview);

	List<RatingOfAppByVersionModel> selectReviewForRatingByVersion(@Param("appName") String appName);

	NumberOfAppReviewModel selectNumberOfAppReview(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

	MonthlyAppRatingModel selectMonthlyAppRating(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
