package com.renanmateus.comic.domain.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class DescontoUtils {

	public static String verificaDiaDesconto(String isbn) {
		if (!isbn.equals("")) {
			char ultimoDigito = isbn.charAt(isbn.length() - 1);
			int digitoVerificador = Character.getNumericValue(ultimoDigito);

			switch (digitoVerificador) {
			case 0:
			case 1:
				return "segunda-feira";
			case 2:
			case 3:
				return "terça-feira";
			case 4:
			case 5:
				return "quarta-feira";
			case 6:
			case 7:
				return "quinta-feira";
			case 8:
			case 9:
				return "sexta-feira";
			}
		}
		return null;
	}

	public static boolean verificaDescontoAtivo(String diaDesconto) {
		if (diaDesconto != null) {
			LocalDate hoje = LocalDate.now();
			DayOfWeek day = hoje.getDayOfWeek();
			String dia = day.getDisplayName(TextStyle.FULL, new Locale("pt"));

			if (diaDesconto.equals(dia)) {
				return true;
			}
		}
		return false;
	}
}
