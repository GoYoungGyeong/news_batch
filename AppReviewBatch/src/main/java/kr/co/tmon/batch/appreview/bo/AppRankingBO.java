package kr.co.tmon.batch.appreview.bo;

import java.io.IOException;

import kr.co.tmon.batch.appreview.dao.AppRankingDAO;
import kr.co.tmon.batch.appreview.model.AppRankingModel;
import kr.co.tmon.batch.appreview.util.ExtractFromJson;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class AppRankingBO {
	@Autowired
	private AppRankingDAO appRankingDAO;

	private ExtractFromJson extractFromJson;

	@Scheduled(fixedDelay = 10800000)
	public void insertAppRanking() throws IOException, ParseException {
		extractFromJson = new ExtractFromJson();
		AppRankingModel appRanking = extractFromJson.getAppRanking();

		appRankingDAO.insertAppRanking(appRanking);
	}

	public void setAppRankingDAO(AppRankingDAO appRankingDAO) {
		this.appRankingDAO = appRankingDAO;
	}

	public void setExtractFromJson(ExtractFromJson extractFromJson) {
		this.extractFromJson = extractFromJson;
	}

}
