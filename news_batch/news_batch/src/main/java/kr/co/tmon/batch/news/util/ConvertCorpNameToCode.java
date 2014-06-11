package kr.co.tmon.batch.news.util;

import java.util.List;

import kr.co.tmon.batch.news.model.News;

/**
 * 
 * @author 김종환
 * 
 *         한글로 넘어오는 카데고리 이름으로 코드명으로 변환해주는 클래스
 * 
 */

public class ConvertCorpNameToCode {
	public List<News> exchangNameToCode(List<News> newsList) {
		for (News news : newsList) {
			news.setNewsSocialCorpCode(corpNameToCode(news.getNewsSocialCorpCode()));
		}

		return newsList;
	}

	public String corpNameToCode(String corpName) {
		if (corpName.compareTo("티켓몬스터") == 0 || corpName.compareTo("tmon") == 0)
			return "tm";

		else if (corpName.compareTo("쿠팡") == 0 || corpName.compareTo("coupang") == 0)
			return "cp";

		else if (corpName.compareTo("위메프") == 0 || corpName.compareTo("wemap") == 0)
			return "wmp";

		else if (corpName.compareTo("social") == 0 || corpName.compareTo("socials") == 0)
			return "socials";

		else
			return "etc";
	}
}
