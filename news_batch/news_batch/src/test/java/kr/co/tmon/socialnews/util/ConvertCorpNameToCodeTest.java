package kr.co.tmon.socialnews.util;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import kr.co.tmon.batch.news.model.News;
import kr.co.tmon.batch.news.util.ConvertCorpNameToCode;

import org.junit.Before;
import org.junit.Test;

public class ConvertCorpNameToCodeTest {
	private ConvertCorpNameToCode convertCorpNameToCode;
	private List<News> newsList;
	private News news;

	@Before
	public void setup() {
		convertCorpNameToCode = new ConvertCorpNameToCode();
	}

	@Test
	public void 모든_corp를_코드로_정상적으로_치환해_리스트로_보내는지_테스트() {
		makeSampleDate(100);
		newsList = convertCorpNameToCode.exchangNameToCode(newsList);

		boolean isValid = true;

		for (News news : newsList) {
			if (news.getNewsSocialCorpCode().compareTo("tm") != 0 && news.getNewsSocialCorpCode().compareTo("cp") != 0 && news.getNewsSocialCorpCode().compareTo("etc") != 0 && news.getNewsSocialCorpCode().compareTo("wmp") != 0)
				isValid = false;
		}

		assertTrue(isValid);
	}

	@Test
	public void 영문corp코드에서도_정상적으로_변환하는지_테스트() {
		assertTrue(convertCorpNameToCode.corpNameToCode("tmon").compareTo("tm") == 0);
	}

	private void makeSampleDate(int numberOfItem) {
		int dailyIndex = 0;
		newsList = new ArrayList<>();

		while (dailyIndex < numberOfItem) {
			Date date = new Date(System.currentTimeMillis());

			news = new News();
			news.setNewsCount(0);
			news.setNewsDate(date);
			news.setNewsID((int) date.getTime() + dailyIndex);
			news.setNewsImage(Integer.toString(dailyIndex));
			news.setNewsLink(Integer.toString(dailyIndex));
			news.setNewsPreview(Integer.toString(dailyIndex));
			news.setNewsProvider(Integer.toString(dailyIndex));
			news.setNewsTitle(Integer.toString(dailyIndex));

			if ((dailyIndex % 2) == 0)
				news.setNewsSocialCorpCode("티켓몬스터");

			else if ((dailyIndex % 3) == 0)
				news.setNewsSocialCorpCode("쿠팡");

			else if ((dailyIndex % 5) == 0)
				news.setNewsSocialCorpCode("위메프");

			else if ((dailyIndex % 7) == 0)
				news.setNewsSocialCorpCode("티켓몬스터,쿠팡");

			else
				news.setNewsSocialCorpCode("기타");

			newsList.add(news);
			dailyIndex++;
		}

	}

}
