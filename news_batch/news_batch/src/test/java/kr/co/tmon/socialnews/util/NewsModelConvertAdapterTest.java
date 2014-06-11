package kr.co.tmon.socialnews.util;

import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import kr.co.tmon.batch.news.model.News;
import kr.co.tmon.batch.news.model.ParsedNews;
import kr.co.tmon.batch.news.util.NewsModelConvertAdapter;

import org.junit.Before;
import org.junit.Test;

public class NewsModelConvertAdapterTest {
	private NewsModelConvertAdapter newsModelConvertAdapter;
	private List<ParsedNews> xmlParsedNews;

	@Before
	public void setup() {
		newsModelConvertAdapter = new NewsModelConvertAdapter();
	}

	@Test
	public void 파싱데이터를_DB뉴스리스트로_정상적으로_변환하는지_테스트() throws ParseException {
		xmlParsedNews = createTestXmlParsedData();
		List<News> convertedNewsList = newsModelConvertAdapter.convertToNewsListForDB(xmlParsedNews);
		assertNotNull(convertedNewsList);
		

	}

	private List<ParsedNews> createTestXmlParsedData() {
		ArrayList<ParsedNews> parsedNewsData = new ArrayList<>();
		ParsedNews parsedNews = new ParsedNews();

		parsedNews.setDate("2014-05-28");
		parsedNews.setImage("blah");
		parsedNews.setLink("blahblah");
		parsedNews.setPreview("blahblahblah");
		parsedNews.setProvider("blahblahblahblah");
		parsedNews.setSocialName("티켓몬스터");
		parsedNews.setTitle("어쩌구저쩌구어쨌든");
		parsedNews.setSimilarNews("5");
		
		for (int index = 0; index < 5; index++)
			parsedNewsData.add(parsedNews);
		
		return parsedNewsData;
	}

}
