package kr.co.tmon.batch.news.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author 김종환
 * 
 * Date타입을 데이터타입에서 인식할 수 있는 형태로 바꿔, sql쿼리를 형태에 맞게 보내기 위해 String타입으로 변환하는 클래스
 * 
 */


public class TypeChangeBetweenDateAndString {
	private static final String SQL_DATE_STYLE = "yyyy-MM-dd";

	public String exchangeToStringType(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(SQL_DATE_STYLE);
		return dateFormat.format(date);
	}

	public java.sql.Date exchangeToDateType(String dateString) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(SQL_DATE_STYLE);
		
		Date date = dateFormat.parse(dateString);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		return sqlDate;
	}
}
