package kr.co.tmon.batch.appreview.util;

import java.util.List;

/**
 * 
 * @author 김종환
 * 
 *         한글로 넘어오는 카데고리 이름으로 코드명으로 변환해주는 클래스
 * 
 */

public class ConvertCorpNameToCode {
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
