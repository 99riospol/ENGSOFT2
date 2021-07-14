package domini.pagament;

public class Metallic implements IFuncionalitats {

	private double quantitatAPgar;
	private double canvi;

	public Metallic(double quantitatAPagar) {
		this.quantitatAPgar = quantitatAPagar;
	}
	
	public void quantitatLliurada(double quantitat) throws Exception {
		if (quantitat < this.quantitatAPgar)
			throw new Exception("La quanttat lliurada és inferior a " + this.quantitatAPgar);
		canvi = quantitat - this.quantitatAPgar;
	}

	public double quantitatDeCanvi() {
		return this.canvi;
	}
}