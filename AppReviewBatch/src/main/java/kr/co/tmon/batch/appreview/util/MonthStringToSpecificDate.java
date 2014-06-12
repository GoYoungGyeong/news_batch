package kr.co.tmon.batch.appreview.util;

import java.sql.Date;
import java.text.ParseException;

/**
 * 
 * @author 김종환
 * 
 *         month단위로 있는 날짜스트링에 일자를 붙여주는 유틸리티 클래스
 * 
 */

public class MonthStringToSpecificDate {
	public String getFirstDayOfMonth(String monthDateString) {
		return monthDateString + "-01";
	}

	public String getLastDayOfMonth(String monthDateString) {
		return monthDateString + "-31";
	}

	public Date getFirstDayOfMonthForDateType(String monthString) throws ParseException {
		TypeChangeBetweenDateAndString typeChangeBetweenDateAndString = new TypeChangeBetweenDateAndString();
		return typeChangeBetweenDateAndString.exchangeToDateType(getFirstDayOfMonth(monthString));
	}

	public Date getLastDayOfMonthForDateType(String monthString) throws ParseException {
		TypeChangeBetweenDateAndString typeChangeBetweenDateAndString = new TypeChangeBetweenDateAndString();
		return typeChangeBetweenDateAndString.exchangeToDateType(getLastDayOfMonth(monthString));
	}
}
