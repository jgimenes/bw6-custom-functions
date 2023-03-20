package br.com.jgimenes.bw.customfunctions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tibco.xml.cxf.common.annotations.XPathFunction;
import com.tibco.xml.cxf.common.annotations.XPathFunctionExample;
import com.tibco.xml.cxf.common.annotations.XPathFunctionGroup;
import com.tibco.xml.cxf.common.annotations.XPathFunctionParameter;

/**
 *
 * TIBCO BusinessWorks 6.X - String Custom Functions
 *
 * @author jgimenes
 * @version 1.0
 * 
 */

@XPathFunctionGroup(category = "Custom String Functions", prefix = "su", namespace = "http://tibco.bw.StringTools", helpText = "Custom-built functions for manipulating strings.")
public class StringUtils {

	/**
	 * 
	 * Check the validity of an email address using regular expressions.
	 * 
	 * @param email
	 * @return isValidEmail
	 * 
	 */

	@XPathFunction(helpText = "Check the validity of an email address using regular expressions.", parameters = {
			@XPathFunctionParameter(name = "email", optional = false, optionalValue = "") }, displayName = "validade-email", returnType = "boolean", examples = {
					@XPathFunctionExample(example = "validade-email(\"user@email.com\")", returns = "true") })

	public Boolean validadeEmail(String email) {
		boolean isValidEmail = false;
		if (email.length() > 0) {
			String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches()) {
				isValidEmail = true;
			}

		}

		return isValidEmail;
	}

	/**
	 * 
	 * Obtain the line count for a given string.
	 * 
	 * @param stringText
	 * @return number lines
	 * 
	 */

	@XPathFunction(helpText = "Obtain the line count for a given string", parameters = {
			@XPathFunctionParameter(name = "string-text", optional = false, optionalValue = "") }, displayName = "count-lines", returnType = "integer", examples = {
					@XPathFunctionExample(example = "count-lines(\"first line. \nsecond line.\")", returns = "2") })

	public Integer countLines(String stringText) {
		return (int) stringText.lines().count();
	}

	/**
	 *
	 * Reverse String.
	 * 
	 * @param stringText
	 * @return reverse string
	 * 
	 */

	@XPathFunction(helpText = "Reverse string.", parameters = {
			@XPathFunctionParameter(name = "string-text", optional = false, optionalValue = "") }, displayName = "string-reverse", returnType = "string", examples = {
					@XPathFunctionExample(example = "string-reverse(\"love\")", returns = "evol") })

	public String reverseString(String stringText) {
		return new StringBuilder(stringText).reverse().toString();
	}

	/**
	 * 
	 * Mask Credit Card Number.
	 * 
	 * @param creditCardNumber
	 * @return masked credit card number
	 * 
	 */

	@XPathFunction(helpText = "Mask credit card number.", parameters = {
			@XPathFunctionParameter(name = "credit-card-number", optional = false, optionalValue = "") }, displayName = "mask-credit-card", returnType = "string", examples = {
					@XPathFunctionExample(example = "string-reverse(\"5348 0866 2159 5908\")", returns = "5***********5908") })

	public String maskCreditCard(String creditCardNumber) {
		creditCardNumber = textNormalizer.normalizeText(creditCardNumber);
		return creditCardNumber.replaceAll("(?<!^).(?=.{4})", "*");
	}

	/**
	 * 
	 * Obtain the word count for a given string.
	 * 
	 * @param stringText
	 * @return words number
	 * 
	 */

	@XPathFunction(helpText = "Obtain the word count for a given string.", parameters = {
			@XPathFunctionParameter(name = "string-text", optional = false, optionalValue = "") }, displayName = "count-words", returnType = "integer", examples = {
					@XPathFunctionExample(example = "count-words(\"word1 word2 word3 word4\")", returns = "4") })

	public Integer countWords(String stringText) {
		String[] words = stringText.split("\\s+");
		return words.length;
	}

	/**
	 * 
	 * Takes a string and formats it based on a given mask.
	 * 
	 * @param stringText
	 * @param mask
	 * @return formatted string text
	 * 
	 */

	@XPathFunction(helpText = "Takes a string and formats it based on a given mask.", parameters = {
			@XPathFunctionParameter(name = "string-text", optional = false, optionalValue = ""),
			@XPathFunctionParameter(name = "mask", optional = false, optionalValue = "") }, displayName = "mask-formatter", returnType = "string", examples = {
					@XPathFunctionExample(example = "mask-formatter(\"999999999\", \"+55 11 #####-####\" )", returns = "\"+55 11 99999-9999\"") })

	public String maskFormatter(String stringText, String mask) {
		return textFormatter.textFormat(stringText, mask);
	}

	/**
	 * 
	 * Convert accented characters to non-accented characters in a string.
	 * 
	 * @param stringText
	 * @return string text without accent.
	 * 
	 */

	@XPathFunction(helpText = "Convert accented characters to non-accented characters in a string.", parameters = {
			@XPathFunctionParameter(name = "string-text", optional = false, optionalValue = "") }, displayName = "remove-accent", returnType = "string", examples = {
					@XPathFunctionExample(example = "remove-accent(\"áàâãç\")", returns = "\"aaaac\"") })

	public String removeAccent(String stringText) {
		return textNormalizer.removeAccents(stringText);
	}

	@XPathFunction(helpText = "Cleans a string by removing all non-alphanumeric characters and keeping only letters and numbers.", parameters = {
			@XPathFunctionParameter(name = "string-text", optional = false, optionalValue = "") }, displayName = "normalize-string", returnType = "string", examples = {
					@XPathFunctionExample(example = "normalize-string(\"a|b-c*d%e$f&g\")", returns = "\"abcdefg\"") })

	public String normailzeString(String stringText) {
		return textNormalizer.normalizeText(stringText);
	}

}
