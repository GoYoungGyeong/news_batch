package kr.co.tmon.batch.news.util;
/**
 * @author 고영경
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateCalculator {
	
	public String getToday() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		Date currentTime = new Date();
		return formatter.format(currentTime);
	}

	public String calculateBeforeDate(String today, int index) throws ParseException {
		final int oneDayMillisecond = 86400000;
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		long beforeDateToLong = formatter.parse(today).getTime() - oneDayMillisecond * index;
		
		Date beforeDateToDate = new Date(beforeDateToLong);
		
		return formatter.format(beforeDateToDate);
	}
}
