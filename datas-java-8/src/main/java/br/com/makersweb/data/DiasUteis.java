package br.com.makersweb.data;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DiasUteis {

	public static Map<YearMonth, List<LocalDate>> doAno(int ano) {
		return diasUteisDosMesesDoAno(mesesDoAno(ano));
	}

	public static List<LocalDate> doMes(int ano, Month mes) {
		return doMes(YearMonth.of(ano, mes));
	}

	public static List<LocalDate> doMes(YearMonth mes) {
		return diasUteisDosMesesDoAno(Stream.of(mes)).get(mes);
	}

	public static Map<YearMonth, List<LocalDate>> dosMeses(List<YearMonth> meses) {
		return diasUteisDosMesesDoAno(meses.stream());
	}

	private static Stream<YearMonth> mesesDoAno(int ano) {
		return Stream.of(Month.values()).map(month -> YearMonth.of(ano, month));
	}

	private static Map<YearMonth, List<LocalDate>> diasUteisDosMesesDoAno(Stream<YearMonth> mesesDoAno) {
		return mesesDoAno.collect(Collectors.toMap(Function.identity(),
				ym -> todosOsDiasDoMesAno(ym).filter(diaUtil()).collect(Collectors.toList())));
	}

	private static Predicate<LocalDate> diaUtil() {
		return date -> !date.getDayOfWeek().equals(DayOfWeek.SATURDAY) && !date.getDayOfWeek().equals(DayOfWeek.SUNDAY);
	}

	private static Stream<LocalDate> todosOsDiasDoMesAno(YearMonth yearMonth) {
		return Stream.iterate(yearMonth.atDay(1), date -> date.plusDays(1)).limit(yearMonth.lengthOfMonth());
	}
}
