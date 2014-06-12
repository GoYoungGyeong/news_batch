package kr.co.tmon.batch.appreview.util;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

public class SubDecimalTest {
	private SubDecimal subDecimal;

	@Before
	public void setup() {
		subDecimal = new SubDecimal();
	}

	@Test
	public void 소수점을_두자리수로_자르는지_확인하는_테스트() {
		float result = subDecimal.subDecimalFromOriginalFloat((float) 5.154687);
		float expected = (float) 5.15;

		System.out.println((float) (Math.round((float) 5.154687 * 100d) / 100d));

		assertTrue(Float.toString(result).compareTo(Float.toString(expected)) == 0);
	}

}
