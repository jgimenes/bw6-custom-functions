package br.com.jgimenes.bw.customfunctions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import com.tibco.xml.cxf.common.annotations.XPathFunction;
import com.tibco.xml.cxf.common.annotations.XPathFunctionExample;
import com.tibco.xml.cxf.common.annotations.XPathFunctionGroup;
import com.tibco.xml.cxf.common.annotations.XPathFunctionParameter;

/**
 *
 * TIBCO BusinessWorks 6.X - Date Time Custom Functions
 *
 * @author jgimenes
 * @version 1.0
 * 
 */

@XPathFunctionGroup(category = "Custom Date/Time Functions", prefix = "dt", namespace = "http://tibco.bw.DateTimeTools", helpText = "Custom-built functions for manipulating dates and times.")
public class DateTimeUtils {

	/**
	 * Convert Epoch time to a readable date format.
	 * 
	 * @param timestamp
	 * @return human readable date
	 * 
	 */

	@XPathFunction(helpText = "Convert Epoch time to a readable date format.", parameters = {
			@XPathFunctionParameter(name = "timestamp", optional = false, optionalValue = "") }, displayName = "epoch-to-human-readable", returnType = "string", examples = {
					@XPathFunctionExample(example = "epoch-to-human-readable(\"1679332277\")", returns = "2023-03-20T14:11:17.017-03:00") } 
	)

	public static String epochToHumanReadable(String timestamp) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sssXXX");
		formatter.setTimeZone(TimeZone.getDefault());
		Long epoch = Long.parseLong(timestamp);
		Date date = new Date( timestamp.length() == 10 ? epoch * 1000 : epoch );
		return formatter.format(date);
	}

	/**
	 *
	 * Convert a readable date format to an Epoch timestamp.
	 * 
	 * @param datetime
	 * @return epoch
	 * 
	 */

	@XPathFunction(helpText = "Convert a readable date format to an Epoch timestamp.", parameters = {
			@XPathFunctionParameter(name = "datetime", optional = false, optionalValue = "") }, displayName = "human-readable-to-epoch", returnType = "string", examples = {
					@XPathFunctionExample(example = "human-readable-to-epoch(\"2023-03-16T16:43:30.030-03:00\")", returns = "true") })

	public static String humanReadableToEpoch(String datetime) {

		LocalDateTime localDateTime = LocalDateTime.parse(datetime, DateTimeFormatter.ISO_DATE_TIME);
		ZonedDateTime LocalDateTimeZone = localDateTime.atZone(ZoneId.systemDefault());
		long epoch = LocalDateTimeZone.toEpochSecond();
		return String.valueOf(epoch);

	}

	/**
	 * 
	 * Retrieves the day number within a year for a given date.
	 * 
	 * @param date
	 * @return day number of year
	 * 
	 */

	@XPathFunction(helpText = "Retrieves the day number within a year for a given date.", parameters = {
			@XPathFunctionParameter(name = "date", optional = false, optionalValue = "") }, displayName = "extract-day-of-year", returnType = "integer", examples = {
					@XPathFunctionExample(example = "extract-day-of-year(\"2023-12-31\")", returns = "365") })

	public static int extractDayOfYear(String date) {
		return extractFromDateOfYear("day", date);
	}

	/**
	 * Retrieves the week number within a year for a given date.
	 * 
	 * @param date
	 * @return month number of year
	 * 
	 */

	@XPathFunction(helpText = "Retrieves the week number within a year for a given date.", parameters = {
			@XPathFunctionParameter(name = "date", optional = false, optionalValue = "") }, displayName = "extract-week-of-year", returnType = "integer", examples = {
					@XPathFunctionExample(example = "extract-week-of-year(\"2023-12-31\")", returns = "53") })

	public static int extractWeekOfYear(String date) {
		return extractFromDateOfYear("week", date);
	}

	/**
	 * Retrieves the day, week or month number within a year for a given date.
	 * 
	 * @param query
	 * @param date
	 * @return integer
	 * 
	 */

	private static int extractFromDateOfYear(String query, String date) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		formatter.setTimeZone(TimeZone.getDefault());
		Calendar calendar = Calendar.getInstance();
		Date d = new Date();
		try {
			d = formatter.parse(date);
			calendar.setTime(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int fromDateOfYear = 0;

		if (query == "day") {
			fromDateOfYear = calendar.get(Calendar.DAY_OF_YEAR);
		} else if (query == "week") {
			fromDateOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
		}

		return fromDateOfYear;

	}
}
