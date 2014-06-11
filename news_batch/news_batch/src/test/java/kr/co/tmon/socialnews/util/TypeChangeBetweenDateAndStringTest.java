package kr.co.tmon.socialnews.util;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.text.ParseException;

import kr.co.tmon.batch.news.util.TypeChangeBetweenDateAndString;

import org.junit.Before;
import org.junit.Test;

public class TypeChangeBetweenDateAndStringTest {
	private TypeChangeBetweenDateAndString typeChangeBetweenDateAndString;

	@Before
	public void setup() {
		typeChangeBetweenDateAndString = new TypeChangeBetweenDateAndString();
	}

	@Test
	public void date타입을_올바르게_SQL문에서_사용하는_String스타일로_리턴하는지_테스트() {
		Date date = new Date(2014 - 1900, 4, 26);
		String dateExpressedSqlStyle = typeChangeBetweenDateAndString.exchangeToStringType(date);
		assertTrue(dateExpressedSqlStyle.compareTo("2014-05-26") == 0);
	}

	@Test
	public void String타입을_Date타입으로_변환하는게_정상적인지_테스트() throws ParseException {
		String dateString = "2014-05-28";
		Date date = (Date) typeChangeBetweenDateAndString.exchangeToDateType(dateString);

		assertTrue(dateString.compareTo(date.toString()) == 0);
	}
}
