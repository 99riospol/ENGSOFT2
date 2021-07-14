package domini;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ProvaInicial {

	public static void main(String[] args) {
		System.out.println(data(new Date(), "FormatNomMes"));
		System.out.println(data(new Date(), "FormatDDMMAA"));
		System.out.println(data(new Date(), "FormatDiaSetmana"));
	}

	private static String data(Date data, String format) {
		return DataFactoria.getInstancia().getEstrategia(format).auxiliar(data);
	}
}