package br.com.jgimenes.bw.customfunctions;

import java.io.Serializable;
import java.text.Normalizer;

public class textNormalizer implements Serializable {

	/**
	 * 
	 * Normalize a string by removing accents and special characters.
	 * 
	 * @author jgimenes
	 * @version 1.0
	 * 
	 */

	private static final long serialVersionUID = 5132721501804691318L;

	/**
	 * 
	 * Remove accents from a string..
	 * 
	 * @param stringText
	 * @return normalized text
	 * 
	 */

	public static String removeAccents(String stringText) {
		if (stringText != null) {
			stringText = Normalizer.normalize(stringText, Normalizer.Form.NFD);
			stringText = stringText.replaceAll("[^\\p{ASCII}]", "");
		}
		return stringText;
	}

	/**
	 * Remove special characters from a string.
	 * 
	 * @param stringText
	 * @return normalized text
	 * 
	 */

	public static String normalizeText(String stringText) {
		if (stringText != null) {
			stringText = stringText.replaceAll("[^A-Za-z0-9]", "");
		}
		return stringText;
	}

}