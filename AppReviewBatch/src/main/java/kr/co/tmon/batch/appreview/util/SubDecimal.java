package kr.co.tmon.batch.appreview.util;

public class SubDecimal {
	public float subDecimalFromOriginalFloat(float originalFloat) {
		float changedFloat = (float) (Math.round(originalFloat * 100d) / 100d);
		return changedFloat;
	}

}
