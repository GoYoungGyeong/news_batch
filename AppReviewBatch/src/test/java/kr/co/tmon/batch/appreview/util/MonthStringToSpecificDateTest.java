package kr.co.tmon.batch.appreview.util;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

public class MonthStringToSpecificDateTest {
	private MonthStringToSpecificDate monthStringToSpecificDate;

	@Before
	public void setup() {
		monthStringToSpecificDate = new MonthStringToSpecificDate();
	}

	@Test
	public void 월의_첫_날짜를_정확히_반환하는지_테스트() {
		String expected = "2014-02-01";
		String testMonthString = "2014-02";

		assertTrue(expected.compareTo(monthStringToSpecificDate.getFirstDayOfMonth(testMonthString)) == 0);
	}

	@Test
	public void 월의_말일을_반환하는지_테스트() {
		String expected = "2014-02-31";
		String testMontString = "2014-02";

		assertTrue(expected.compareTo(monthStringToSpecificDate.getLastDayOfMonth(testMontString)) == 0);

	}

	@Test
	public void 월의_초일을_Date타입으로_반환하는지_알아보는_테스트() throws ParseException {
		String montString = "2014-03";
		String dateString = "2014-03-01";
		TypeChangeBetweenDateAndString typeChangeBetweenDateAndString = new TypeChangeBetweenDateAndString();
		Date expectedDate = typeChangeBetweenDateAndString.exchangeToDateType(dateString);
		System.out.println(monthStringToSpecificDate.getFirstDayOfMonthForDateType(montString));
		assertTrue(expectedDate.compareTo(monthStringToSpecificDate.getFirstDayOfMonthForDateType(montString)) == 0);
	}

	@Test
	public void 월의_말일을_Date타입으로_반환하는지_알아보는_테스트() throws ParseException {
		String montString = "2014-03";
		String dateString = "2014-03-31";
		TypeChangeBetweenDateAndString typeChangeBetweenDateAndString = new TypeChangeBetweenDateAndString();
		Date expectedDate = typeChangeBetweenDateAndString.exchangeToDateType(dateString);
		System.out.println(monthStringToSpecificDate.getLastDayOfMonthForDateType(montString));
		assertTrue(expectedDate.compareTo(monthStringToSpecificDate.getLastDayOfMonthForDateType(montString)) == 0);
	}
}
