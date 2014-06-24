package kr.co.tmon.batch.appreview.bo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import kr.co.tmon.batch.appreview.dao.AppRankingDAO;
import kr.co.tmon.batch.appreview.model.AppRankingModel;
import kr.co.tmon.batch.appreview.util.ExtractFromJson;

import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

public class AppRankingBOTest {
	private AppRankingBO appRankingBO;

	@Before
	public void setup() {
		appRankingBO = new AppRankingBO();
	}

	@Test
	public void 데이터를_파싱해_받아와_DB에_insert하는_기능작동_테스트() throws IOException, ParseException {
		ExtractFromJson mockedExtractFromJson = mock(ExtractFromJson.class);
		AppRankingDAO mockedAppRankingDAO = mock(AppRankingDAO.class);
		AppRankingModel fakedAppRanking = generateSampleModel();

		when(mockedExtractFromJson.getAppRanking()).thenReturn(fakedAppRanking);

		appRankingBO.setExtractFromJson(mockedExtractFromJson);
		appRankingBO.setAppRankingDAO(mockedAppRankingDAO);

		appRankingBO.insertAppRanking();
		verify(mockedAppRankingDAO, times(1));
	}

	private AppRankingModel generateSampleModel() {
		AppRankingModel appRanking = new AppRankingModel();
		appRanking.setCoupangRank(5);
		appRanking.setTmonRank(7);
		appRanking.setWemapRank(43);
		appRanking.setDateString("2014-06-20 03시");

		return appRanking;
	}
}
