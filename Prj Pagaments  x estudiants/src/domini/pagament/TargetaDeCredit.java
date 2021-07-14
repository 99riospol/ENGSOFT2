package domini.pagament;

public class TargetaDeCredit {

	private double quantitatAPgar;
	private String dadesTarjetaCredit;

	public TargetaDeCredit(double quantitatAPagar, String dadesTarjetaCredit) {
		this.quantitatAPgar = quantitatAPagar;
		this.dadesTarjetaCredit = dadesTarjetaCredit;
	}

	public void quantitatLliurada(double quantitat) throws Exception {
		throw new Exception("Mètode no aplicable.");
	}

	public double quantitatDeCanvi() {
		System.out.println(dadesTarjetaCredit);
		int numero = (int) (Math.random() * 2);
		return numero - 1;
	}
}