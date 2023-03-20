package br.com.jgimenes.bw.customfunctions;

import java.io.Serializable;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class textFormatter implements Serializable {

	/**
	 * 
	 * Format a given string according to a specified mask.
	 * 
	 * @author jgimenes
	 * @version 1.0
	 *  
	 */

	private static final long serialVersionUID = 5132721501804691318L;

	public static String textFormat(String stringText, String mask) {

		String formattedText = null;

		try {
			MaskFormatter formatter = new MaskFormatter(mask.trim());
			formatter.setValueContainsLiteralCharacters(false);
			formattedText = formatter.valueToString(stringText.trim());
		} catch (ParseException err) {
			err.printStackTrace();
		}

		return formattedText.trim().toString();

	}

}