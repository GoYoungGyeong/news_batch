package kr.co.tmon.batch.news.dao;

import org.apache.ibatis.annotations.Param;

import kr.co.tmon.batch.news.model.CountSocialNews;
import kr.co.tmon.batch.news.model.News;

/**
 * 
 * @author 김종환
 * @author 고영경
 * 
 */

/*
 * News클래스에 대한 매핑 클래스
 */

public interface NewsMapper {

	void insertNews(News news);

	void mappingSocialCode(News news);

	int selectTodayNewsCountForInsert(@Param("socialCorpCode") String social_corpCode, @Param("today") String today);

	void insertNewsCount(CountSocialNews countSocialNews);
}
