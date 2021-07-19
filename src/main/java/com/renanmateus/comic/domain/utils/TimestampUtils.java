package com.renanmateus.comic.domain.utils;

import org.springframework.stereotype.Component;

@Component
public class TimestampUtils {

	public static String geraTimestamp() {
		return String.valueOf(new java.sql.Timestamp(System.currentTimeMillis()).getTime());
	}
}
