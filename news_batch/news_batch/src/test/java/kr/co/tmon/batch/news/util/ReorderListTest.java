package kr.co.tmon.batch.news.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import kr.co.tmon.batch.news.model.News;

import org.junit.Before;
import org.junit.Test;

public class ReorderListTest {
	private ReorderList reorderList;

	@Before
	public void setup() {
		reorderList = new ReorderList();
	}

	@Test
	public void 역순으로_재정렬되는지_테스트() {
		List<News> newsList = generateNewsList();
		newsList = reorderList.reorderList(newsList);

		assertEquals(55, newsList.get(0).getNewsID());
	}

	private List<News> generateNewsList() {
		List<News> newsList = new ArrayList<>();
		News firstNews = new News();
		firstNews.setNewsID(21);

		News secondNews = new News();
		secondNews.setNewsID(55);

		newsList.add(firstNews);
		newsList.add(secondNews);

		return newsList;
	}

}
