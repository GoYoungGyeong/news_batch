package kr.co.tmon.batch.appreview.util;

import java.sql.Date;

/**
 * 
 * @author 김종환
 * 
 *         일반 날짜 string을 월간 날짜 String으로 자르는 클래스
 * 
 */

public class SubstringForYearPlusMonth {
	public String substringOfDate(Date date) {
		TypeChangeBetweenDateAndString typeChangeBetweenDateAndString = new TypeChangeBetweenDateAndString();
		String originalDateString = typeChangeBetweenDateAndString.exchangeToStringType(date);

		return originalDateString.substring(0, 7);
	}

	public String getCurrentMonthString() {
		Date date = new Date(System.currentTimeMillis());
		return substringOfDate(date);
	}
}
