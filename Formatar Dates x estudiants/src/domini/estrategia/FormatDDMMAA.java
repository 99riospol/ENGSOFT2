package domini.estrategia;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class FormatDDMMAA implements IEstrategia{

	@Override
	public String auxiliar(Date ex) {
		LocalDate localDate2 = ex.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return localDate2.format(DateTimeFormatter.ofPattern("dd/MM/yy"));
	}

}
