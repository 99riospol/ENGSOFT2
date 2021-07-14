package domini.pagament;

import persistencia.TPV;

public class FactoriaTargetaDeCredit {

	public TargetaDeCredit crearPagament(double quantitat) {
		String dadesTarjeta = TPV.llegirDadesTarjeta();
		return new TargetaDeCredit(quantitat, dadesTarjeta);
	}
}