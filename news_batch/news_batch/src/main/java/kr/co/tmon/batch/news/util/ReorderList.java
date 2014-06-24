package kr.co.tmon.batch.news.util;

import java.util.ArrayList;
import java.util.List;

import kr.co.tmon.batch.news.model.News;

public class ReorderList {
	public List<News> reorderList(List<News> newsList) {
		List<News> reorderedList = new ArrayList<>();

		for (int index = newsList.size() - 1; index >= 0; index--)
			reorderedList.add(newsList.get(index));

		return reorderedList;
	}

}
