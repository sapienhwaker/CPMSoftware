/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.okstate.executables;

/**
 *
 * @author CIVE Administrator
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Crunchify.com
 * 
 */

public class CurrentDateTime {

	public static String get() {

		Date today = Calendar.getInstance().getTime();

		// Constructs a SimpleDateFormat using the given pattern
		SimpleDateFormat crunchifyFormat = new SimpleDateFormat("MMM dd yyyy HH:mm:ss.SSS zzz");

		// format() formats a Date into a date/time string.
		String currentTime = crunchifyFormat.format(today);

		try {

			// parse() parses text from the beginning of the given string to produce a date.
			Date date = crunchifyFormat.parse(currentTime);

			// getTime() returns the number of milliseconds since January 1, 1970, 00:00:00 GMT represented by this Date object.

			return Long.toString(date.getTime());


		} catch (ParseException e) {
			e.printStackTrace();
		}

		return "new";
	}
}
