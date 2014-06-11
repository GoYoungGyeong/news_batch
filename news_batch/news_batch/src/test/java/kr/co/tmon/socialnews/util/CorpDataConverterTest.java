package kr.co.tmon.socialnews.util;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import kr.co.tmon.batch.news.model.News;
import kr.co.tmon.batch.news.util.CorpDataConverter;

import org.junit.Before;
import org.junit.Test;

public class CorpDataConverterTest {
	private CorpDataConverter corpDateConvertForMapping;
	private List<News> newsList;

	@Before
	public void setup() {
		corpDateConvertForMapping = new CorpDataConverter();
	}

	@Test
	public void 정상적으로_중복된_corp가_추가되는지_테스트() {
		makeSampleDate(5);
		newsList.get(0).setNewsSocialCorpCode("tm");
		newsList.get(1).setNewsSocialCorpCode("tm,cp,wmp");
		newsList.get(2).setNewsSocialCorpCode("wmp");
		newsList.get(3).setNewsSocialCorpCode("소셜커머스");
		newsList.get(4).setNewsSocialCorpCode("cp");

		corpDateConvertForMapping.divideByCorps(newsList);
	}

	private void makeSampleDate(int numberOfItem) {
		int dailyIndex = 0;
		newsList = new ArrayList<>();
		News news;

		while (dailyIndex < numberOfItem) {
			news = new News();
			news.setNewsCount(0);
			news.setNewsDate(new Date(System.currentTimeMillis()));
			news.setNewsID(100 + dailyIndex);
			news.setNewsImage(Integer.toString(dailyIndex));
			news.setNewsLink(Integer.toString(dailyIndex));
			news.setNewsPreview(Integer.toString(dailyIndex));
			news.setNewsProvider(Integer.toString(dailyIndex));
			news.setNewsTitle(Integer.toString(dailyIndex));

			List<String> corpList = new ArrayList<>();

			if ((dailyIndex % 4) == 0)
				news.setNewsSocialCorpCode("tm");

			else if ((dailyIndex % 4) == 1)
				news.setNewsSocialCorpCode("cp");

			else if ((dailyIndex % 4) == 2)
				news.setNewsSocialCorpCode("wmp");

			else
				news.setNewsSocialCorpCode("etc");

			newsList.add(news);
			dailyIndex++;
		}
	}
}
