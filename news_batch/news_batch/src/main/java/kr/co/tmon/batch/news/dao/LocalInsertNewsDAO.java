package kr.co.tmon.batch.news.dao;

import java.util.List;

import kr.co.tmon.batch.news.model.News;
import kr.co.tmon.batch.news.util.ConvertCorpNameToCode;
import kr.co.tmon.batch.news.util.CorpDataConverter;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author 김종환
 * 
 *         파싱된 뉴스데이터를 DB에 집어넣는 클래스
 * 
 */

@Repository
public class LocalInsertNewsDAO {
	private static final int START_INSERT_INDEX_EXAMING_DUPLICATE = 1;
	@Autowired
	private SqlSession sqlSession;

	public void insertNews(List<News> parsedNewsList) {
		NewsMapper newsMapper = sqlSession.getMapper(NewsMapper.class);

		parsedNewsList = convertingCorpCode(parsedNewsList);
		
		newsMapper.insertNews(parsedNewsList.get(0));
		insertNewsAsUnique(parsedNewsList, newsMapper);

		for (News news : parsedNewsList)
			newsMapper.mappingSocialCode(news);
	}

	private List<News> convertingCorpCode(List<News> parsedNewsList) {
		CorpDataConverter corpDataConverter = new CorpDataConverter();
		parsedNewsList = corpDataConverter.divideByCorps(parsedNewsList);
		ConvertCorpNameToCode convertKoreanCorpNameToCode = new ConvertCorpNameToCode();
		parsedNewsList = convertKoreanCorpNameToCode.exchangNameToCode(parsedNewsList);
		return parsedNewsList;
	}

	private void insertNewsAsUnique(List<News> parsedNewsList, NewsMapper newsMapper) {
		for (int index = START_INSERT_INDEX_EXAMING_DUPLICATE; index < parsedNewsList.size(); index++) {
			News news = parsedNewsList.get(index);
			if (news.getNewsID() != parsedNewsList.get(index - 1).getNewsID()) {
				if (news.getNewsTitle().length() > 20)
					news.setNewsTitle(news.getNewsTitle().substring(0, 18) + "..");
				newsMapper.insertNews(news);
			}
		}
	}

}
