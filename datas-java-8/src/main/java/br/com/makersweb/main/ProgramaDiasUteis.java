package br.com.makersweb.main;

import java.time.Month;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;

import br.com.makersweb.data.DiasUteis;

public class ProgramaDiasUteis {

	public static void main(String[] args) {
		// Dias �teis do Ano
		System.out.println("Dias �teis do Ano");
		System.out.println(DiasUteis.doAno(2016));

		// Dias �teis do M�s
		System.out.println("Dias �teis do M�s:");
		System.out.println(DiasUteis.doMes(2016, Month.JULY));

		// Dias �teis do M�s
		System.out.println("Dias �teis do M�s 2:");
		System.out.println(DiasUteis.doMes(YearMonth.of(2016, Month.JULY)));

		// Dias �teis dos Meses de Abril e Maio
		System.out.println("Dias �teis dos Meses de Abril e Maio:");
		List<YearMonth> abrilEMaio = Arrays.asList(YearMonth.of(2016, Month.APRIL), YearMonth.of(2016, Month.MAY));
		System.out.println(DiasUteis.dosMeses(abrilEMaio));
	}

}
