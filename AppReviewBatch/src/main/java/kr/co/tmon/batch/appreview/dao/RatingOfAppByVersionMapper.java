package kr.co.tmon.batch.appreview.dao;

import java.util.List;

import kr.co.tmon.batch.appreview.model.RatingOfAppByVersionModel;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author 김종환
 * 
 */

public interface RatingOfAppByVersionMapper {
	void insertRatingOfAppByVersion(RatingOfAppByVersionModel ratingOfAppByVersion);

	List<RatingOfAppByVersionModel> selectLastestFiveVersionRating(@Param("appName") String appName);
}
