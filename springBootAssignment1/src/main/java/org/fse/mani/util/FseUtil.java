package org.fse.mani.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FseUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FseUtil.class);
	

	public static LocalDate convertStringtoDate(String date) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		date = date.substring(0,10);
		LOGGER.info("Date : "+date);
		
		//convert String to LocalDate
		LocalDate localDate = LocalDate.parse(date, formatter);
		LOGGER.info("Converted Date : "+localDate);
		return localDate;
	}
	
	
}
